package com.example.demo.mapper;

import com.example.demo.entity.KnowledgePoint;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KnowledgePointMapper {

    void insertBatchKnowledgePoint(List<KnowledgePoint> list);

    List<KnowledgePoint> findAll(String knowledgeId);

    void insertKnowledgeTreeNode(KnowledgePoint knowledgePoint);

    void updateTreeRoot(@Param("id") Integer id, @Param("knowledgeId") String knowledgeId);

    void updateTreeContent(String content, Integer id);

    void deleteTreeNode(List<Integer> ids, String knowledgeId);

    String findTreePath(String path);

    void deleteTree(String knowledgeId);

    List<Integer> getChild(@Param("id") String knowledgeId,
                           @Param("regx") String regx);
}
