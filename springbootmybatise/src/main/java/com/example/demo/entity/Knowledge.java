package com.example.demo.entity;

public class Knowledge {

    private String knowledgeId;

    private String knowledgeName;

    private String courseId;

    public Knowledge(String knowledgeId, String knowledgeName, String courseId) {
        this.knowledgeId = knowledgeId;
        this.knowledgeName = knowledgeName;
        this.courseId = courseId;
    }

    public String getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(String knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public String getKnowledgeName() {
        return knowledgeName;
    }

    public void setKnowledgeName(String knowledgeName) {
        this.knowledgeName = knowledgeName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}