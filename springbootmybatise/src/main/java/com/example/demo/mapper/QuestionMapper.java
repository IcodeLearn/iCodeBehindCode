package com.example.demo.mapper;

import com.example.demo.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionMapper {

    Question findQuestionByText(@Param("text") String oneText, @Param("id") String sourceId, @Param("questionType")String questionType);

    void insertQuestion(Question question);

    List<Question> findAllQuestionById(String sourceId);

    List<Question> findAllQuestionByIdAndType(@Param("type") String type, @Param("sourceId") String sourceId);
}
