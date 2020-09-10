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

    List<Question> findTestAllQuestion(@Param("testId") String testId, @Param("sortBy")List<String> sortBy);

    void insertTestQuestion(@Param("testId") String testId, @Param("QuestionId") String questionId);

   // List<Question> findTestAllQuestionByType(@Param("testId") String testId, @Param("type") String questionType);

    void insertBatchTestQuestion(@Param("list") List<Integer> list, @Param("testId") String testId);

    boolean isExistQuestion(String testId);
}
