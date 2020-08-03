package com.example.demo.controller;

import com.example.demo.service.KnowledgeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@RestController
public class KnowledgeController {

    @Autowired
    private KnowledgeService service;

    @PostMapping("/teacher/knowledge")
    public HashMap<String, Object> insertKnowledge(MultipartFile uploadFile, @Param("courseId") String courseId,
                                                   @Param("knowledgeName") String knowledgeName) {
        return service.insertKnowledge(uploadFile, courseId, knowledgeName);
    }

    @PostMapping("/teacher/knowledge_isCover")
    public HashMap<String, Object> isCover(boolean isCover) {
        return service.isCoverKnowledge(isCover);
    }
}
