package com.example.demo.entity;

// 多选
public class MoreChoice {
    // ID
    private String moreId;
    // 题目
    private String moreText;
    // 选项A
    private String moreA;
    // 选项B
    private String moreB;
    // 选项C
    private String moreC;
    // 选项D
    private String moreD;
    // 选项E
    private String moreE;
    // 选项F
    private String moreF;
    // 选项答案
    private String moreAnswer;
    // 解析
    private String moreParse;
    // 难度
    private String moreLevel;

    private String sourceId;

    public MoreChoice(String moreId, String moreText, String moreA, String moreB, String moreC, String moreD, String moreE, String moreF, String moreAnswer, String moreParse, String moreLevel, String sourceId) {
        this.moreId = moreId;
        this.moreText = moreText;
        this.moreA = moreA;
        this.moreB = moreB;
        this.moreC = moreC;
        this.moreD = moreD;
        this.moreE = moreE;
        this.moreF = moreF;
        this.moreAnswer = moreAnswer;
        this.moreParse = moreParse;
        this.moreLevel = moreLevel;
        this.sourceId = sourceId;
    }

    public String getMoreParse() {
        return moreParse;
    }

    public void setMoreParse(String moreParse) {
        this.moreParse = moreParse;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getMoreId() {
        return moreId;
    }

    public void setMoreId(String moreId) {
        this.moreId = moreId;
    }

    public String getMoreText() {
        return moreText;
    }

    public void setMoreText(String moreText) {
        this.moreText = moreText;
    }

    public String getMoreA() {
        return moreA;
    }

    public void setMoreA(String moreA) {
        this.moreA = moreA;
    }

    public String getMoreB() {
        return moreB;
    }

    public void setMoreB(String moreB) {
        this.moreB = moreB;
    }

    public String getMoreC() {
        return moreC;
    }

    public void setMoreC(String moreC) {
        this.moreC = moreC;
    }

    public String getMoreD() {
        return moreD;
    }

    public void setMoreD(String moreD) {
        this.moreD = moreD;
    }

    public String getMoreE() {
        return moreE;
    }

    public void setMoreE(String moreE) {
        this.moreE = moreE;
    }

    public String getMoreF() {
        return moreF;
    }

    public void setMoreF(String moreF) {
        this.moreF = moreF;
    }

    public String getMoreAnswer() {
        return moreAnswer;
    }

    public void setMoreAnswer(String moreAnswer) {
        this.moreAnswer = moreAnswer;
    }

    public String getMoreLevel() {
        return moreLevel;
    }

    public void setMoreLevel(String moreLevel) {
        this.moreLevel = moreLevel;
    }
}
