package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.mapper.SourceMapper;
import com.example.demo.utils.MyStringUtil;
import com.example.demo.utils.ResultMap;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
/*
题库分为几张表，增加了空间的浪费，代码的冗余，但是
节约了时间，提高了增删改查的效率，两权相害取其轻
web网页时间比空间更为重要
 */
@Service
public class SourceService {

    @Autowired
    private SourceMapper sourceMapper;

    @Autowired
    private OneChoiceService oneChoiceService;

    @Autowired
    private MoreChoiceService moreChoiceService;

    @Autowired
    private CompletionService completionService;

    @Autowired
    private AnswerQuestionService answerQuestionService;

    @Autowired
    private CodeQuestionService codeQuestionService;

    private Random random = new Random();

    // 默认存放题库文件位置
    private static  final String path = "src/main/resources/static/questionbank/";

    /**
     * 创建一个题库或者选择覆盖文件
     * @param file 上传的文件
     * @param courseId 课程 Id
     * @param uid 用户 Id
     * @return
     */
    public HashMap<String, Object> createSource(MultipartFile file, String courseId, String uid) {

            // 获取文件名
            String fileName = UUID.randomUUID().toString() + file.getOriginalFilename();
            // 获取文件类型
            //String fileType = fileName.substring(fileName.indexOf(".") + 1);
            String[] fileTypes = fileName.split("\\.");
            String fileType = fileTypes[fileTypes.length - 1];
            // 上传时间
            Date fileUploadTime = new Date(System.currentTimeMillis());
            String sourceId = UUID.randomUUID().toString();
            String filePath = path + uid;
            File dest = new File(filePath);
            if(!dest.exists()) {
                // 创建文件夹
                dest.mkdirs();
            }
            // 文件最终存放位置
            // 获取文件的绝对路径
            File destFile = new File(dest.getAbsolutePath() + File.separator + fileName);
            // 文件上传
            try {
                file.transferTo(destFile);
                Source s = findSourceByTeacherAndCourse(courseId, uid);
                boolean isCover = s != null;
                if(s == null) {
                    // 创建题库
                    s = new Source(sourceId, fileName, fileType, fileUploadTime, filePath, courseId, uid);
                    sourceMapper.createSource(s);
                }else {
                    // 更新 题库
                    s = new Source(s.getSourceId(), fileName, fileType, fileUploadTime, filePath, courseId, uid);
                    sourceMapper.updateSourceById(s);
                    //s = sourceMapper.findBySourceById(s.getSourceId());
                }
                readExcel(s, isCover);
                return ResultMap.setResult("200", s, "添加成功！");
            } catch (IOException e) {
                System.out.println("题库文件上传失败！");
                e.printStackTrace();
            }
        return null;
    }

    /**
     * 业务逻辑：上传文件保存时，首先查询该教师该门课程是否已有该文件
     * 1. 返回值为null 直接添加
     * 2. 返回值不为null 做判断 是否覆盖
     * @return
     */
    public Source findSourceByTeacherAndCourse(String courseId, String uid) {
        return sourceMapper.findSourceByTeacherAndCourse(courseId, uid);
    }

    // 将文件导入数据库
    // isCover 是否需要覆盖, 根据查询结果返回
    private void readExcel(Source source, Boolean isCover) {
        String filePath = source.getSourcePath();
        String fileName = source.getSourceName();
        String fileId = source.getSourceId();
        File file = new File(filePath + File.separator + fileName);
        // 解析excel文件
        try {
            Workbook workbook = Workbook.getWorkbook(file);
            Sheet sheet = workbook.getSheet(0);
            System.out.println(sheet.getColumns());
            int columns = sheet.getColumns();
            for (int col = 1; col < columns; col++) {

                // 获取题型
                Cell cell = sheet.getCell(col, 0);
                String type = MyStringUtil.replaceSpecialStr(cell.getContents());
                System.out.println("type: " + type);
                // 生成一个随机ID
                String id = UUID.randomUUID().toString();

                 //同时需要向题库_题联系表中增加一条记录
                switch (type){
                    case "单选题":
                        System.out.println("我是单选题！");
                        String oneText = sheet.getCell(col, 1).getContents();
                        if(isCover && oneChoiceService.findOneChoiceByText(oneText, fileId) != null) {

                            System.out.println("有一道题重复!");
                            break;
                        }
                        String oneA = sheet.getCell(col, 2).getContents();
                        String oneB = sheet.getCell(col, 3).getContents();
                        String oneC = sheet.getCell(col, 4).getContents();
                        String oneD = sheet.getCell(col, 5).getContents();
                        String oneE = sheet.getCell(col, 6).getContents();
                        String oneF = sheet.getCell(col, 7).getContents();
                        String oneAnswer = sheet.getCell(col, 8).getContents();
                        String oneParse = sheet.getCell(col, 9).getContents();
                        String oneLevel = sheet.getCell(col, 10).getContents();
                        oneChoiceService.insertOneChoice(new OneChoice(id, oneText, oneA, oneB, oneC, oneD,
                                oneE, oneF, oneAnswer, oneParse, oneLevel, fileId));
                        break;
                    case "多选题":
                        System.out.println("我是多选题!");
                        String moreText = sheet.getCell(col, 1).getContents();
                        if(isCover && moreChoiceService.findMoreChoiceByText(moreText, fileId) != null) {
                            System.out.println("有一道题重复!");
                            break;
                        }
                        String moreA = sheet.getCell(col, 2).getContents();
                        String moreB = sheet.getCell(col, 3).getContents();
                        String moreC = sheet.getCell(col, 4).getContents();
                        String moreD = sheet.getCell(col, 5).getContents();
                        String moreE = sheet.getCell(col, 6).getContents();
                        String moreF = sheet.getCell(col, 7).getContents();
                        String moreAnswer = sheet.getCell(col, 8).getContents();
                        String moreParse = sheet.getCell(col, 9).getContents();
                        String moreLevel = sheet.getCell(col, 10).getContents();
                        System.out.println("获取到的sourceid: " + fileId);
                        moreChoiceService.insertMoreChoice(new MoreChoice(id, moreText, moreA, moreB, moreC, moreD, moreE,
                                moreF, moreAnswer, moreParse, moreLevel, fileId));
                        break;
                    case "填空题":
                        System.out.println("这是一道填空题");
                        String completionText = sheet.getCell(col, 1).getContents();
                        if(isCover && completionService.findCompletionByText(completionText, fileId) != null) {
                            System.out.println("有一道题重复!");
                            break;
                        }
                        String completionA = sheet.getCell(col, 2).getContents();
                        String completionB = sheet.getCell(col, 3).getContents();
                        String completionC = sheet.getCell(col, 4).getContents();
                        String completionD = sheet.getCell(col, 5).getContents();
                        String completionE = sheet.getCell(col, 6).getContents();
                        String completionF = sheet.getCell(col, 7).getContents();
                        String completionParse = sheet.getCell(col, 9).getContents();
                        String completionLevel = sheet.getCell(col, 10).getContents();

                        completionService.insertCompletion(new Completion(id, completionText, completionA, completionB,
                                completionC, completionD, completionE, completionF, completionParse, completionLevel, fileId));
                        break;
                    case "主观题":
                        System.out.println("这是一道简答题!");
                        String answerQuestionText = sheet.getCell(col, 1).getContents();
                        if(isCover && answerQuestionService.findAnswerQuestionByText(answerQuestionText, fileId) != null) {
                            System.out.println("有一道题重复!");
                            break;
                        }
                        String aqA = sheet.getCell(col, 2).getContents();
                        String aqB = sheet.getCell(col, 3).getContents();
                        String aqC = sheet.getCell(col, 4).getContents();
                        String aqD = sheet.getCell(col, 5).getContents();
                        String aqE = sheet.getCell(col, 6).getContents();
                        String aqF = sheet.getCell(col, 7).getContents();
                        String aqParse = sheet.getCell(col, 9).getContents();
                        String aqLevel = sheet.getCell(col, 10).getContents();
                        answerQuestionService.insertAnswerQuestion(new AnswerQuestion(id, answerQuestionText, aqA,
                                aqB, aqC, aqD, aqE, aqF, aqParse, aqLevel, fileId));
                        break;
                    case "代码题":
                        System.out.println("这是一道编码题！");
                        String codeText = sheet.getCell(col, 1).getContents();
                        if(isCover &&  codeQuestionService.findCodeQuestionByText(codeText, fileId)!= null) {
                            System.out.println("有一道题重复!");
                            break;
                        }
                        int count = 0;
                        String codeAnswer = null;
                        for (int i = 2; i <= 7; i++) {
                            String content = sheet.getCell(col, i).getContents();
                            if(!StringUtils.isEmpty(content) && !StringUtils.isAllBlank(content)) {
                                count++;
                                codeAnswer = content;
                            }
                        }

                        if(count > 1) {
                            throw new IllegalArgumentException("代码题只能有一个答案!");
                        }
                        String codeParse = sheet.getCell(col, 9).getContents();
                        String codeLevel = sheet.getCell(col, 10).getContents();
                        String codeType = sheet.getCell(col, 11).getContents();
                        codeQuestionService.insertCodeQuestion(new CodeQuestion(id, codeText, codeAnswer, codeParse, codeLevel, codeType, fileId));
                        break;
                    case "是非题":
                    case "数值题":
                        break;

                    default:
                        throw new IllegalArgumentException("没有这个题型！");
                }
            }
        } catch (IOException | BiffException e) {
            e.printStackTrace();
        }
    }
}
