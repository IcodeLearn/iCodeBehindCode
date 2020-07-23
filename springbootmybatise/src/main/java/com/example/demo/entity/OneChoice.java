package com.example.demo.entity;

// 单选题类
public class OneChoice {

    // ID
    private String oneId;
    // 题目
    private String oneText;
    // 选项A
    private String oneA;
    // 选项B
    private String oneB;
    // 选项C
    private String oneC;
    // 选项D
    private String oneD;
    // 选项E
    private String oneE;
    // 选项F
    private String oneF;
    // 选项答案
    private String oneAnswer;
    // 解析
    private String oneParse;
    // 难度
    private String oneLevel;

    // 题库ID
    private String sourceId;

    public OneChoice(String oneId, String oneText, String oneA, String oneB, String oneC, String oneD, String oneE,
                     String oneF, String oneAnswer, String oneParse ,String oneLevel, String sourceId) {

        this.oneId = oneId;
        this.oneText = oneText;
        this.oneA = oneA;
        this.oneB = oneB;
        this.oneC = oneC;
        this.oneD = oneD;
        this.oneE = oneE;
        this.oneF = oneF;
        this.oneAnswer = oneAnswer;
        this.oneParse = oneParse;
        this.oneLevel = oneLevel;
        this.sourceId = sourceId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getOneParse() {
        return oneParse;
    }

    public void setOneParse(String oneParse) {
        this.oneParse = oneParse;
    }

    public String getOneId() {
        return oneId;
    }

    public void setOneId(String oneId) {
        this.oneId = oneId;
    }

    public String getOneText() {
        return oneText;
    }

    public void setOneText(String oneText) {
        this.oneText = oneText;
    }

    public String getOneA() {
        return oneA;
    }

    public void setOneA(String oneA) {
        this.oneA = oneA;
    }

    public String getOneB() {
        return oneB;
    }

    public void setOneB(String oneB) {
        this.oneB = oneB;
    }

    public String getOneC() {
        return oneC;
    }

    public void setOneC(String oneC) {
        this.oneC = oneC;
    }

    public String getOneD() {
        return oneD;
    }

    public void setOneD(String oneD) {
        this.oneD = oneD;
    }

    public String getOneE() {
        return oneE;
    }

    public void setOneE(String oneE) {
        this.oneE = oneE;
    }

    public String getOneF() {
        return oneF;
    }

    public void setOneF(String oneF) {
        this.oneF = oneF;
    }

    public String getOneAnswer() {
        return oneAnswer;
    }

    public void setOneAnswer(String oneAnswer) {
        this.oneAnswer = oneAnswer;
    }

    public String getOneLevel() {
        return oneLevel;
    }

    public void setOneLevel(String oneLevel) {
        this.oneLevel = oneLevel;
    }
}
