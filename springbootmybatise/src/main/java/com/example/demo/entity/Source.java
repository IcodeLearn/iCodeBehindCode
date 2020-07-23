package com.example.demo.entity;

import java.util.Date;

// 题库文件
public class Source {

    private String sourceId;

    private String sourceName;

    private String sourceType;

    private Date sourceUploadTime;

    private String sourcePath;

    private String courseId;

    private String uid;

    public Source(String sourceName, String courseId, String uid) {
        this.sourceName = sourceName;
        this.courseId = courseId;
        this.uid = uid;
    }

    public Source(String sourceId, String sourceName, String sourceType, Date sourceUploadTime, String sourcePath,
                  String courseId, String uid) {
        this.sourceId = sourceId;
        this.sourceName = sourceName;
        this.sourceType = sourceType;
        this.sourceUploadTime = sourceUploadTime;
        this.sourcePath = sourcePath;
        this.courseId = courseId;
        this.uid = uid;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public Date getSourceUploadTime() {
        return sourceUploadTime;
    }

    public void setSourceUploadTime(Date sourceUploadTime) {
        this.sourceUploadTime = sourceUploadTime;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
