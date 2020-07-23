package com.example.demo.entity;

public class AnswerQuestion {

    private String aqId;

    private String aqText;

    private String aqA;

    private String aqB;

    private String aqC;

    private String aqD;

    private String aqE;

    private String aqF;

    private String aqParse;

    private String aqLevel;

    private String sourceId;

    public AnswerQuestion(String aqId, String aqText, String aqA, String aqB, String aqC, String aqD, String aqE, String aqF, String aqParse, String aqLevel, String sourceId) {
        this.aqId = aqId;
        this.aqText = aqText;
        this.aqA = aqA;
        this.aqB = aqB;
        this.aqC = aqC;
        this.aqD = aqD;
        this.aqE = aqE;
        this.aqF = aqF;
        this.aqParse = aqParse;
        this.aqLevel = aqLevel;
        this.sourceId = sourceId;
    }

    public String getAqA() {
        return aqA;
    }

    public void setAqA(String aqA) {
        this.aqA = aqA;
    }

    public String getAqB() {
        return aqB;
    }

    public void setAqB(String aqB) {
        this.aqB = aqB;
    }

    public String getAqC() {
        return aqC;
    }

    public void setAqC(String aqC) {
        this.aqC = aqC;
    }

    public String getAqD() {
        return aqD;
    }

    public void setAqD(String aqD) {
        this.aqD = aqD;
    }

    public String getAqE() {
        return aqE;
    }

    public void setAqE(String aqE) {
        this.aqE = aqE;
    }

    public String getAqF() {
        return aqF;
    }

    public void setAqF(String aqF) {
        this.aqF = aqF;
    }

    public String getAqParse() {
        return aqParse;
    }

    public void setAqParse(String aqParse) {
        this.aqParse = aqParse;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getAqId() {
        return aqId;
    }

    public void setAqId(String aqId) {
        this.aqId = aqId;
    }

    public String getAqText() {
        return aqText;
    }

    public void setAqText(String aqText) {
        this.aqText = aqText;
    }

    public String getAqLevel() {
        return aqLevel;
    }

    public void setAqLevel(String aqLevel) {
        this.aqLevel = aqLevel;
    }
}
