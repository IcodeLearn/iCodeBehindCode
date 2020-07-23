package com.example.demo.mapper;

import com.example.demo.entity.Completion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CompletionMapper {
    Completion findCompletionByText(@Param("text") String completionText, @Param("id") String sourceId);

    void insertCompletion(Completion completion);
}
