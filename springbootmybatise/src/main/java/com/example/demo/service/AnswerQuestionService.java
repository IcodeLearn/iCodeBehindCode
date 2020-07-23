package com.example.demo.service;

import com.example.demo.entity.AnswerQuestion;
import com.example.demo.mapper.AnswerQuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerQuestionService {

    @Autowired
    private AnswerQuestionMapper mapper;

    public AnswerQuestion findAnswerQuestionByText(String answerQuestionText, String sourceId) {
        return mapper.findAnswerQuestionByText(answerQuestionText, sourceId);
    }

    void insertAnswerQuestion(AnswerQuestion answerQuestion) {
        mapper.insertAnswerQuestion(answerQuestion);
    }
}
