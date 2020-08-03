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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

@Service
public class SourceService {

    @Autowired
    private SourceMapper sourceMapper;

    @Autowired
    private QuestionService questionService;

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
    private Source findSourceByTeacherAndCourse(String courseId, String uid) {
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
                String questionType = MyStringUtil.replaceSpecialStr(cell.getContents());
                System.out.println("type: " + questionType);
                if(!questionType.equals("单选题") && !questionType.equals("多选题") && !questionType.equals("填空题") && !questionType.equals("简答题") &&
                        !questionType.equals("判断题") && !questionType.equals("代码题")) {
                    throw new IllegalArgumentException("错误的题型输入！");
                }
                // 生成一个随机ID
                String id = UUID.randomUUID().toString();

                //同时需要向题库_题联系表中增加一条记录
                String questionText = sheet.getCell(col, 1).getContents();
                if (isCover && questionService.findQuestionByText(questionText, fileId, questionType) != null) {
                    System.out.println("有一道题重复!");
                    break;
                }
                String questionA = sheet.getCell(col, 2).getContents();
                String questionB = sheet.getCell(col, 3).getContents();
                String questionC = sheet.getCell(col, 4).getContents();
                String questionD = sheet.getCell(col, 5).getContents();
                String questionE = sheet.getCell(col, 6).getContents();
                String questionF = sheet.getCell(col, 7).getContents();
                String questionAnswer = sheet.getCell(col, 8).getContents();
                String questionParse = sheet.getCell(col, 9).getContents();
                String questionLevel = sheet.getCell(col, 10).getContents();
                String lType = sheet.getCell(col, 11).getContents();
                questionService.insertQuestion(new Question(id, questionText, questionA, questionB, questionC, questionD,
                        questionE, questionF, questionAnswer, questionParse, questionLevel, questionType, lType, fileId));
            }
        } catch (IOException | BiffException e) {
            e.printStackTrace();
        }
    }
}
