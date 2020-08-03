package com.example.demo.entity;

public class KnowledgePoint {

    // 编号
    private Integer id;

    // 路径
    private String path;

    // 知识点内容
    private String content;

    // 是否是根节点
    private boolean isRoot;

    // 归属于哪一个知识点题库
    private String knowledgeId;

    public KnowledgePoint(Integer id, String path, String content, boolean isRoot, String knowledgeId) {
        this.id = id;
        this.path = path;
        this.content = content;
        this.isRoot = isRoot;
        this.knowledgeId = knowledgeId;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    public String getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(String knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
