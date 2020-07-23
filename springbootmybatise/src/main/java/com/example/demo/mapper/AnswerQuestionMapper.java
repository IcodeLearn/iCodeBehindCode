package com.example.demo.mapper;

import com.example.demo.entity.AnswerQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AnswerQuestionMapper {

    AnswerQuestion findAnswerQuestionByText(@Param("text") String answerQuestionText, @Param("id") String sourceId);

    void insertAnswerQuestion(AnswerQuestion answerQuestion);


}
