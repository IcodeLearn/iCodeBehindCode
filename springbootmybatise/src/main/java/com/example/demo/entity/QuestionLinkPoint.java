package com.example.demo.entity;

import java.util.List;

// 问题与知识点的联系
public class QuestionLinkPoint {

    public String questionId;

    public List<Integer> ids;

    public QuestionLinkPoint(String questionId, List<Integer> ids) {
        this.questionId = questionId;
        this.ids = ids;
    }

}
