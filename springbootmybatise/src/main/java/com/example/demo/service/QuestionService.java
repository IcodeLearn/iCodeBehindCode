package com.example.demo.service;

import com.example.demo.entity.Question;
import com.example.demo.mapper.QuestionMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper mapper;

    Question findQuestionByText(@Param("text") String questionText, @Param("id") String sourceId, @Param("questionType") String questionType) {
        return mapper.findQuestionByText(questionText, sourceId, questionType);
    }

    void insertQuestion(Question question) {
        mapper.insertQuestion(question);
    }

    public List<Question> findAllQuestionById(String sourceId) {
        return mapper.findAllQuestionById(sourceId);
    }

    List<Question> findAllQuestionByIdAndType(String type, String sourceId) {
        return mapper.findAllQuestionByIdAndType(type, sourceId);
    }
}
