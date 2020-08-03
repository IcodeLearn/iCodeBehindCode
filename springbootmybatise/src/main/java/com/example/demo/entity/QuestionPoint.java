package com.example.demo.entity;

// 题对应的分值
public class QuestionPoint {

    private String questionType;

    private Integer point;

    private Integer count;

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
