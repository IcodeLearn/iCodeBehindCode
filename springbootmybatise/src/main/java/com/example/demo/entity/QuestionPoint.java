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
    private List<Integer> ids;

    public QuestionPoint(String questionType, Integer point, Integer count, List<Integer> ids) {
        this.questionType = questionType;
        this.point = point;
        this.count = count;
        this.ids = ids;
    }

    public List<Integer> getIds() {
        return ids;
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
