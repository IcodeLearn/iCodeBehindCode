package com.example.demo.service;

import com.example.demo.entity.Question;
import com.example.demo.entity.QuestionPoint;
import com.example.demo.entity.Test;
import com.example.demo.mapper.TestMapper;
import com.example.demo.utils.ResultMap;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TestService {

    @Autowired
    private TestMapper mapper;

    @Autowired
    private QuestionService questionService;

    // 创建测试
    public HashMap<String, Object> createTest(Test test) {
        mapper.createTest(test);
        return ResultMap.setResult("200", null, "测试创建成功");
    }

    // 获取该课程的所有测试
    public HashMap<String, Object> findAllTest(String courseId) {
        return ResultMap.setResult("200", mapper.findAllTest(courseId), "课程的所有测试");
    }

    // 获取某一个测试的所有题
    public HashMap<String, Object> findTestAllQuestion(String testId) {
        return ResultMap.setResult("200", mapper.findTestAllQuestion(testId), "测试的所有的题");
    }

    // 自动组卷
    // 1. 用户选择关于组卷的基本参数
    // （1） 题目类型 - 及其题目数量
    // （2） 每种类型 - 分数
    // （3） 所涉及到的知识点
    // 2. 当选择的知识点有子结点时，子结点对应的相关题目同样需要考虑

    public HashMap<String, Object> groupVolume(List<QuestionPoint> questionPointList, String sourceId, String testId) throws Exception {
        if(questionPointList == null) {
            throw new NullPointerException("组卷参数为空，无法自定组卷");
        }

        // 首先获取该测试已存在的所有该种题型
        List<Question> q = mapper.findTestAllQuestion(testId);
        if(q != null) {
            return ResultMap.setResult("400", q, "该测试已有试题，如需自动组卷，请先删除试题");
        }

        Set<Question> questions = new LinkedHashSet<>();

        for (QuestionPoint question : questionPointList) {
            String questionType = question.getQuestionType();
            int count = question.getCount();
            int point = question.getPoint();

            // 返回该题型的结果
            // 并打乱List
            List<Question> temp = questionService.findAllQuestionByIdAndType(questionType, sourceId);
            if(temp.size() == 0 ) {
                throw new Exception("题库中" + questionType + "数量为0");
            }
            Collections.shuffle(temp);
            // 获取前count个
            if(temp.size() < count) {
                // 如果题库题少于输入的count，则用数据库中的数量代替count
                count = temp.size();
            }

            List<Question> oneTypeQuestions = temp.subList(0, count);
            System.out.println("数组的长度: " + oneTypeQuestions.size());

            for (Question oneTypeQuestion : oneTypeQuestions) {
                mapper.insertTestQuestion(testId, oneTypeQuestion.getQuestionId(), point);
            }

            questions.addAll(oneTypeQuestions);
        }
        return ResultMap.setResult("200", questions, "组卷成功");
    }
}
