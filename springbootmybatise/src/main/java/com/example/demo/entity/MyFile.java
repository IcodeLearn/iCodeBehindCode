package com.example.demo.entity;

import java.util.Date;

public class MyFile {

    private String fileName;

    private String fileType;

    private Date fileUploadTime;

    private String sourceId;

    private String filePath;

    private String fileAbsolutePath;

    public MyFile(String fileName, String fileType, Date fileUploadTime, String sourceId, String filePath, String fileAbsolutePath) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileUploadTime = fileUploadTime;
        this.sourceId = sourceId;
        this.filePath = filePath;
        this.fileAbsolutePath = fileAbsolutePath;
    }

    public String getFileAbsolutePath() {
        return fileAbsolutePath;
    }

    public void setFileAbsolutePath(String fileAbsolutePath) {
        this.fileAbsolutePath = fileAbsolutePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Date getFileUploadTime() {
        return fileUploadTime;
    }

    public void setFileUploadTime(Date fileUploadTime) {
        this.fileUploadTime = fileUploadTime;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
