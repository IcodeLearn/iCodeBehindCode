package com.example.demo.service;


import com.example.demo.entity.Knowledge;
import com.example.demo.entity.MyFile;
import com.example.demo.mapper.KnowledgeMapper;
import com.example.demo.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

@Service
public class KnowledgeService {

    @Autowired
    private KnowledgeMapper mapper;

    @Autowired
    private KnowledgePointService knowledgePointService;

    private static Knowledge knowledge;

    // 默认存放题库文件位置
    private static  final String path = "src/main/resources/static/knowledge/";

    public Knowledge findKnowledgeByCourseId(String courseId) {
        return mapper.findKnowledgeByCourseId(courseId);
    }

    public HashMap<String, Object> insertKnowledge(MultipartFile file, String courseId, String knowledgeName) {
        Knowledge k = findKnowledgeByCourseId(courseId);
        if(k != null) {
            knowledge = k;
            return ResultMap.setResult("200", null, "该课程已有知识树，是否覆盖？");
        }
        String knowledgeId = UUID.randomUUID().toString();

     //   mapper.insertKnowledge(new Knowledge(knowledgeId, knowledgeName, courseId));
        // 将文件信息存入日志信息中
        // 使用Redis记录

        // 将文件上传 , 并解析Excel
        String destFileName = UUID.randomUUID().toString() + file.getOriginalFilename();

        File destFile = new File(new File(path).getAbsolutePath() + File.separator + destFileName);
        try {
            if(!destFile.exists()) {
                destFile.createNewFile();
            }
            file.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        knowledgePointService.uploadFileKnowledge(destFile, knowledgeId);
        return ResultMap.setResult("200", null, "添加成功");
    }

    public void deleteKnowledge(String knowledgeId) {
        mapper.deleteKnowledge(knowledgeId);
    }

    public HashMap<String, Object> isCoverKnowledge(boolean isCover) {
        if(isCover) {
            // 上传文件
            // 更新Redis数据库记录

            return null;
        }
        return null;
    }
}
