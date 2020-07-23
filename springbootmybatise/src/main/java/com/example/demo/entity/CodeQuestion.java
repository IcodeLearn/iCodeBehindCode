package com.example.demo.entity;

// 代码编写题
public class CodeQuestion {

    private String codeId;

    private String codeText;

    private String codeAnswer;

    private String codeParse;

    private String codeLevel;

    private String sourceId;

    private String codeType;

    public CodeQuestion(String codeId, String codeText, String codeAnswer, String codeParse, String codeLevel, String codeType,
                        String sourceId) {
        this.codeId = codeId;
        this.codeText = codeText;
        this.codeAnswer = codeAnswer;
        this.codeParse = codeParse;
        this.codeLevel = codeLevel;
        this.codeType = codeType;
        this.sourceId = sourceId;
    }



    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getCodeParse() {
        return codeParse;
    }

    public void setCodeParse(String codeParse) {
        this.codeParse = codeParse;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getCodeText() {
        return codeText;
    }

    public void setCodeText(String codeText) {
        this.codeText = codeText;
    }

    public String getCodeAnswer() {
        return codeAnswer;
    }

    public void setCodeAnswer(String codeAnswer) {
        this.codeAnswer = codeAnswer;
    }

    public String getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(String codeLevel) {
        this.codeLevel = codeLevel;
    }
}
