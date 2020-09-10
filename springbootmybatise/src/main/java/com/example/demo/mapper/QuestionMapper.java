package com.example.demo.mapper;

import com.example.demo.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface QuestionMapper {

    Question findQuestionByText(@Param("text") String oneText, @Param("id") String sourceId, @Param("questionType")String questionType);

    void insertQuestion(Question question);

    List<Question> findAllQuestionById(@Param("sourceId") String sourceId, @Param("sortBy") List<String> sortBy);

    List<Question> findAllQuestionByIdAndType(@Param("type") String type, @Param("sourceId") String sourceId);

    int getCountByType(@Param("type") String type, @Param("id") String sourceId);

    List<Integer> selectQuestionByKnowledge(@Param("questionType") String questionType, @Param("set") Set<Integer> set);
}
