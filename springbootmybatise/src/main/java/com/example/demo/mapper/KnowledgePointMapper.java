package com.example.demo.mapper;

import com.example.demo.entity.KnowledgePoint;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KnowledgePointMapper {

    void insertBatchKnowledgePoint(List<KnowledgePoint> list);

    List<KnowledgePoint> findAll(String knowledgeId);
}
