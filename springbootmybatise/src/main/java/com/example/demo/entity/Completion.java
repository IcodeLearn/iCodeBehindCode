package com.example.demo.entity;

// 填空题
public class Completion {

    private String completionId;

    private String completionText;

    private String completionA;

    private String completionB;

    private String completionC;

    private String completionD;

    private String completionE;

    private String completionF;

    private String completionParse;

    private String completionLevel;

    private String sourceId;

    public Completion(String completionId, String completionText, String completionA, String completionB, String completionC, String completionD, String completionE, String completionF, String completionParse, String completionLevel, String sourceId) {
        this.completionId = completionId;
        this.completionText = completionText;
        this.completionA = completionA;
        this.completionB = completionB;
        this.completionC = completionC;
        this.completionD = completionD;
        this.completionE = completionE;
        this.completionF = completionF;
        this.completionParse = completionParse;
        this.completionLevel = completionLevel;
        this.sourceId = sourceId;
    }

    public String getCompletionParse() {
        return completionParse;
    }

    public void setCompletionParse(String completionParse) {
        this.completionParse = completionParse;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getCompletionId() {
        return completionId;
    }

    public void setCompletionId(String completionId) {
        this.completionId = completionId;
    }

    public String getCompletionText() {
        return completionText;
    }

    public void setCompletionText(String completionText) {
        this.completionText = completionText;
    }

    public String getCompletionA() {
        return completionA;
    }

    public void setCompletionA(String completionA) {
        this.completionA = completionA;
    }

    public String getCompletionB() {
        return completionB;
    }

    public void setCompletionB(String completionB) {
        this.completionB = completionB;
    }

    public String getCompletionC() {
        return completionC;
    }

    public void setCompletionC(String completionC) {
        this.completionC = completionC;
    }

    public String getCompletionD() {
        return completionD;
    }

    public void setCompletionD(String completionD) {
        this.completionD = completionD;
    }

    public String getCompletionE() {
        return completionE;
    }

    public void setCompletionE(String completionE) {
        this.completionE = completionE;
    }

    public String getCompletionF() {
        return completionF;
    }

    public void setCompletionF(String completionF) {
        this.completionF = completionF;
    }

    public String getCompletionLevel() {
        return completionLevel;
    }

    public void setCompletionLevel(String completionLevel) {
        this.completionLevel = completionLevel;
    }
}
