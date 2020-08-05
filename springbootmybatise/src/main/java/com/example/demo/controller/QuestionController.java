package com.example.demo.controller;

import com.example.demo.entity.Question;
import com.example.demo.service.QuestionService;
import com.example.demo.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService service;

    @GetMapping("/user/questions")
    public HashMap<String, Object> getAllQuestion(String sourceId) {
        return ResultMap.setResult("200", service.findAllQuestionById(sourceId), "获取所有题");
    }
}
