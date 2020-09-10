package com.example.demo.controller;

import com.example.demo.service.StudentReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class StudentController {

    @Autowired
    private StudentReplyService service;

    // 学生获取所有题，不含答案和解析
    // 包括学生作答情况
    @GetMapping("/student/test/questions")
    public HashMap<String, Object> studentGetAllQuestion(String testId, String uid) {
        return  service.studentGetAllQuestionById(testId, uid);
    }
}
