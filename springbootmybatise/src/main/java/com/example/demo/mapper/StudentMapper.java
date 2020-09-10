package com.example.demo.mapper;

import com.example.demo.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {

    List<Question> studentGetAllQuestionById(@Param("testId") String testId, @Param("sortBy") List<String> sortBy);

    String getQuestionAnswer(String questionId);

    void insertOrUpdateReply(String testId, String uid, String questionId, String Reply);
}
