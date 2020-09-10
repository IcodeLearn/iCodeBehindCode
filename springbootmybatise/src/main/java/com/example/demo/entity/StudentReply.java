package com.example.demo.entity;

public class StudentReply {

    // 题ID
    private String questionId;
    // 学生的回答 （单选题、多选题、判断题）
    private String questionAnswer;

    // 题
    private Question question;

    public StudentReply(Question question, String questionAnswer) {
        this.questionAnswer = questionAnswer;
        this.question = question;
    }

    public StudentReply(String questionId, String questionAnswer) {
        this.questionId = questionId;
        this.questionAnswer = questionAnswer;
    }

    public StudentReply() {
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }
}
