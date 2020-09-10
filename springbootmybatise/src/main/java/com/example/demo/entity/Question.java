package com.example.demo.entity;

// 单选题类
public class Question {

    // ID
    private String questionId;
    // 题目
    private String questionText;
    // 选项A
    private String questionA;
    // 选项B
    private String questionB;
    // 选项C
    private String questionC;
    // 选项D
    private String questionD;
    // 选项E
    private String questionE;
    // 选项F
    private String questionF;
    // 选项答案
    private String questionAnswer;
    // 解析
    private String questionParse;
    // 难度
    private String questionLevel;
    // 题的类型
    private String questionType;
    // 如果题为编程题，则该属性为语言类型
    private String lType;

    // 题库ID
    private String sourceId;

    public Question(String questionId, String questionText, String questionA, String questionB, String questionC, String questionD, String questionE, String questionF, String questionAnswer, String questionParse, String questionLevel, String questionType, String type, String sourceId) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.questionA = questionA;
        this.questionB = questionB;
        this.questionC = questionC;
        this.questionD = questionD;
        this.questionE = questionE;
        this.questionF = questionF;
        this.questionAnswer = questionAnswer;
        this.questionParse = questionParse;
        this.questionLevel = questionLevel;
        this.questionType = questionType;
        this.lType = type;
        this.sourceId = sourceId;
    }

    public Question(String questionId, String questionText, String questionA, String questionB, String questionC, String questionD, String questionE, String questionF, String questionLevel, String questionType, String lType, String sourceId) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.questionA = questionA;
        this.questionB = questionB;
        this.questionC = questionC;
        this.questionD = questionD;
        this.questionE = questionE;
        this.questionF = questionF;
        this.questionLevel = questionLevel;
        this.questionType = questionType;
        this.lType = lType;
        this.sourceId = sourceId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionA() {
        return questionA;
    }

    public void setQuestionA(String questionA) {
        this.questionA = questionA;
    }

    public String getQuestionB() {
        return questionB;
    }

    public void setQuestionB(String questionB) {
        this.questionB = questionB;
    }

    public String getQuestionC() {
        return questionC;
    }

    public void setQuestionC(String questionC) {
        this.questionC = questionC;
    }

    public String getQuestionD() {
        return questionD;
    }

    public void setQuestionD(String questionD) {
        this.questionD = questionD;
    }

    public String getQuestionE() {
        return questionE;
    }

    public void setQuestionE(String questionE) {
        this.questionE = questionE;
    }

    public String getQuestionF() {
        return questionF;
    }

    public void setQuestionF(String questionF) {
        this.questionF = questionF;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getQuestionParse() {
        return questionParse;
    }

    public void setQuestionParse(String questionParse) {
        this.questionParse = questionParse;
    }

    public String getQuestionLevel() {
        return questionLevel;
    }

    public void setQuestionLevel(String questionLevel) {
        this.questionLevel = questionLevel;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getlType() {
        return lType;
    }

    public void setlType(String lType) {
        this.lType = lType;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }
}
