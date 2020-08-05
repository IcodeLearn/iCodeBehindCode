package com.example.demo.controller;

import com.example.demo.entity.Knowledge;
import com.example.demo.entity.KnowledgePoint;
import com.example.demo.service.KnowledgeService;
import com.example.demo.utils.ResultMap;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@RestController
public class KnowledgeController {

    @Autowired
    private KnowledgeService service;

    @PostMapping("/teacher/knowledge_tree")
    public HashMap<String, Object> insertKnowledge(MultipartFile uploadFile, @Param("courseId") String courseId,
                                                   @Param("knowledgeName") String knowledgeName) {
        return service.insertKnowledge(uploadFile, courseId, knowledgeName);
    }

    @PostMapping("/teacher/knowledge_isCover")
    public HashMap<String, Object> isCover(boolean isCover) {
        return service.isCoverKnowledge(isCover);
    }

    @GetMapping("/user/knowledge_tree")
    public HashMap<String, Object> getKnowledgeTree(String courseId) {
        return service.getKnowledgeTree(courseId);
    }

    // 为知识树添加单个结点
    @PostMapping("/teacher/knowledge_tree_node")
    public void insertKnowledgeTreeNode(@RequestBody KnowledgePoint point, @Param("rootId") Integer rootId) {
        service.insertKnowledgeTreeNode(point, rootId);
    }

    @DeleteMapping("/teacher/knowledge_tree_node")
    public void deleteTreeNode(Integer nodeId, String knowledgeId, boolean isRoot) {
        service.deleteTreeNode(nodeId, knowledgeId, isRoot);
    }

    @GetMapping("/user/test")
    public HashMap<String, Object> test() {
        return ResultMap.setResult("200", new Knowledge("1", "test", "1"), null);
    }
}
