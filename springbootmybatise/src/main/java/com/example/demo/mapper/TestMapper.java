package com.example.demo.mapper;

import com.example.demo.entity.Question;
import com.example.demo.entity.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TestMapper {

    void createTest(Test test);

    List<Test> findAllTest(String courseId);

    List<Question> findTestAllQuestion(String testId);

    void insertTestQuestion(@Param("testId") String testId, @Param("QuestionId") String questionId, @Param("point") int point);

    List<Question> findTestAllQuestionByType(@Param("testId") String testId, @Param("type") String questionType);
}
