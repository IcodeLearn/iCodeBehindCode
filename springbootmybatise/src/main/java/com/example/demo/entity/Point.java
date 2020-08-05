package com.example.demo.entity;

import java.util.List;

public class Point extends KnowledgePoint{

    private List<Point> nodes;

    public Point(KnowledgePoint knowledgePoint, List<Point> nodes) {
        super(knowledgePoint.getId(), knowledgePoint.getPath(), knowledgePoint.getContent(), knowledgePoint.isRoot(),
                knowledgePoint.getKnowledgeId());
        this.nodes = nodes;
    }

    public List<Point> getNodes() {
        return nodes;
    }

    public void setNodes(List<Point> nodes) {
        this.nodes = nodes;
    }
}
