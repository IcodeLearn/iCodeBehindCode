package com.example.demo.service;


import com.example.demo.entity.Knowledge;
import com.example.demo.entity.KnowledgePoint;
import com.example.demo.entity.Point;
import com.example.demo.entity.QuestionLinkPoint;
import com.example.demo.mapper.KnowledgeMapper;
import com.example.demo.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

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
            return ResultMap.setResult("201", knowledge, "该课程已有知识树，是否覆盖？");
        }
        String knowledgeId = UUID.randomUUID().toString();
        knowledge = new Knowledge(knowledgeId, knowledgeName, courseId);
        mapper.insertKnowledge(knowledge);
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
        return ResultMap.setResult("200", knowledge, "添加成功");
    }

    public void deleteKnowledge(String knowledgeId) {
        mapper.deleteKnowledge(knowledgeId);
    }

    public HashMap<String, Object> isCoverKnowledge(boolean isCover) {
        if(isCover) {
            // 上传文件
            // 更新Redis数据库记录

            deleteKnowledge(knowledge.getKnowledgeId());
            //insertKnowledge(uploadFile, id, name);
            return null;
        }
        return null;
    }

    public HashMap<String, Object> getKnowledgeTree(String courseId) {
        Knowledge k = findKnowledgeByCourseId(courseId);
        if(k == null) {
            return ResultMap.setResult("200", null, "知识树为空");
        }
        Point tree = knowledgePointService.readDatabase(k.getKnowledgeId());
        return ResultMap.setResult("200", tree, "获取知识树成功");
    }

    public void insertKnowledgeTreeNode(KnowledgePoint knowledgePoint, Integer rootId) {
        knowledgePointService.insertKnowledgeTreeNode(knowledgePoint, rootId);
    }

    public void deleteTreeNode(Integer nodeId, String knowledgeId, boolean isRoot) {
        knowledgePointService.deleteTreeNode(nodeId, knowledgeId, isRoot);
    }

    public void questionLinkToKnowledgePoint(List<QuestionLinkPoint> links) {
        // 1. 一道题可以对应多个知识点
        // 2. questionId -> (kid1, kid2, kid3)
        mapper.questionLinkToKnowledgePoint(links);
    }

    public static void main(String[] args) {
        List<QuestionLinkPoint> links = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        links.add(new QuestionLinkPoint("123", ids));

        links.add(new QuestionLinkPoint("456", ids));

        //new KnowledgeService().questionLinkToKnowledgePoint(links);
        //System.out.println(new KnowledgeService().mapper);
    }
}
