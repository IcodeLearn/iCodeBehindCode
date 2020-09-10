package com.example.demo.controller;

import com.example.demo.entity.Question;
import com.example.demo.entity.QuestionPoint;
import com.example.demo.entity.Test;
import com.example.demo.service.TestService;
import com.example.demo.utils.ResultMap;
import com.example.demo.vo.VoQuestionPoint;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public HashMap<String, Object> groupVolume(@RequestBody VoQuestionPoint voQuestionPoint) {
        try {
            return testService.groupVolume(voQuestionPoint.getQuestionPointList(), voQuestionPoint.getSourceId(),
                    voQuestionPoint.getTestId(), voQuestionPoint.getKnowledgeId(), voQuestionPoint.isNeedKnowledge());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMap.setResult("400", null, e.getMessage());
        }
    }

}
