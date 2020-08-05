package com.example.demo.mapper;

import com.example.demo.entity.Knowledge;
import com.example.demo.entity.QuestionLinkPoint;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KnowledgeMapper {
    Knowledge findKnowledgeByCourseId(String courseId);

    void insertKnowledge(Knowledge knowledge);

    void deleteKnowledge(String knowledgeId);

    void updateKnowledge(Knowledge knowledge);

    void questionLinkToKnowledgePoint(List<QuestionLinkPoint> links);
}
