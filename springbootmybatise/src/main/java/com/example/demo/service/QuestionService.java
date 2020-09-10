package com.example.demo.service;

import com.example.demo.entity.Question;
import com.example.demo.mapper.QuestionMapper;
import com.example.demo.utils.ResultMap;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper mapper;

    @Autowired
    private List<String> sortByTypes;


    Question findQuestionByText(@Param("text") String questionText, @Param("id") String sourceId, @Param("questionType") String questionType) {
        return mapper.findQuestionByText(questionText, sourceId, questionType);
    }

    void insertQuestion(Question question) {
        mapper.insertQuestion(question);
    }

    public List<Question> findAllQuestionById(String sourceId) {
        List<String> types = sortByTypes;
        return mapper.findAllQuestionById(sourceId, types);
    }

    List<Question> findAllQuestionByIdAndType(String type, String sourceId) {
        return mapper.findAllQuestionByIdAndType(type, sourceId);
    }

    // 获取数据库中 各种题型的数量
    public HashMap<String, Object> getCountByTypes(String sourceId) {
        List<String> types = sortByTypes;
        HashMap<String, Integer> typeAndCount = new HashMap<>();
        for (String type : types) {
            int count = mapper.getCountByType(type, sourceId);
            typeAndCount.put(type, count);
        }
        return ResultMap.setResult("200", typeAndCount, "获取成功!");
    }

    public int getCountByType(String type, String sourceId) {
        return mapper.getCountByType(type, sourceId);
    }

    public List<Integer> selectQuestionByKnowledge(String questionType, Set<Integer> set) {
        return mapper.selectQuestionByKnowledge(questionType, set);
    }


}
