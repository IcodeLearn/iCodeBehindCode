package com.example.demo.entity;

import java.util.List;

// 题对应的分值
public class QuestionPoint {
    // 题目类型
    private String questionType;
    // 题目分数
    private Integer point;
    // 题目数量
    private Integer count;

    // 可选参数、知识点Id
    List<Integer> ids;

    public QuestionPoint(String questionType, Integer point, Integer count) {
        this.questionType = questionType;
        this.point = point;
        this.count = count;
    }

    public String getQuestionType() {
        return questionType;
    }

    public Integer getPoint() {
        return point;
    }

    public Integer getCount() {
        return count;
    }
}
