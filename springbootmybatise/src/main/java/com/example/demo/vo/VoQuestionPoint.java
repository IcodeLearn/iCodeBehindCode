package com.example.demo.vo;

import com.example.demo.entity.QuestionPoint;

import java.util.List;

public class VoQuestionPoint {

    private List<QuestionPoint> questionPointList;

    private String sourceId;

    private String testId;

    private String knowledgeId;

    private boolean isNeedKnowledge;

    private VoQuestionPoint(List<QuestionPoint> questionPointList, String sourceId, String testId, String knowledgeId,
                            boolean isNeedKnowledge) {
        this.questionPointList = questionPointList;
        this.sourceId = sourceId;
        this.testId = testId;
        this.knowledgeId = knowledgeId;
        this.isNeedKnowledge = isNeedKnowledge;
    }

    public static VoQuestionPoint valueOf(List<QuestionPoint> questionPointList, String sourceId, String testId, String knowledgeId,
                                          boolean isNeedKnowledge) {
        return new VoQuestionPoint(questionPointList, sourceId, testId, knowledgeId, isNeedKnowledge);
    }

    public List<QuestionPoint> getQuestionPointList() {
        return questionPointList;
    }

    public String getSourceId() {
        return sourceId;
    }

    public String getTestId() {
        return testId;
    }

    public String getKnowledgeId() {
        return knowledgeId;
    }

    public boolean isNeedKnowledge() {
        return isNeedKnowledge;
    }
}
