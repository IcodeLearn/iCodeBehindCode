package com.example.demo.mapper;

import com.example.demo.entity.Knowledge;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KnowledgeMapper {
    Knowledge findKnowledgeByCourseId(String courseId);

    void insertKnowledge(Knowledge knowledge);

    void deleteKnowledge(String knowledgeId);

    void updateKnowledge(Knowledge knowledge);
}
