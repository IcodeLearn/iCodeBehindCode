package com.example.demo.controller;

import com.example.demo.entity.QuestionPoint;
import com.example.demo.entity.Test;
import com.example.demo.service.TestService;
import com.example.demo.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/teacher/test")
    public HashMap<String, Object> createTest(@RequestBody Test test) {
        return testService.createTest(test);
    }

    @GetMapping("/teacher/tests")
    public HashMap<String, Object> findAllTest(String courseId) {
        return testService.findAllTest(courseId);
    }

    @GetMapping("/teacher/test/questions")
    public HashMap<String, Object> findTestAllQuestion(String testId) {
        return testService.findTestAllQuestion(testId);
    }

    @PostMapping("/teacher/auto_test")
    public HashMap<String, Object> groupVolume(List<QuestionPoint> questionPointList, String sourceId, String testId) {
        try {
            return testService.groupVolume(questionPointList, sourceId, testId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMap.setResult("400", null, e.getMessage());
        }
    }
}
