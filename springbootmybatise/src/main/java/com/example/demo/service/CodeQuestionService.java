package com.example.demo.service;

import com.example.demo.entity.CodeQuestion;
import com.example.demo.mapper.CodeQuestionMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeQuestionService {

    @Autowired
    private CodeQuestionMapper mapper;

    public CodeQuestion findCodeQuestionByText(@Param("text") String codeQuestionText, @Param("id") String sourceId) {
        return mapper.findCodeQuestionByText(codeQuestionText, sourceId);
    }

    public void insertCodeQuestion(CodeQuestion codeQuestion) {
        mapper.insertCodeQuestion(codeQuestion);
    }
}
