package com.example.demo.mapper;

import com.example.demo.entity.CodeQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CodeQuestionMapper {
    CodeQuestion findCodeQuestionByText(@Param("text") String codeQuestionText, @Param("id") String sourceId);

    void insertCodeQuestion(CodeQuestion codeQuestion);

    List<CodeQuestion> findCodeQuestionById(String sourceId);
}
