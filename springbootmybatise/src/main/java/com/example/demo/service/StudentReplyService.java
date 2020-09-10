package com.example.demo.service;

import com.example.demo.entity.Question;
import com.example.demo.entity.StudentReply;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentReplyService {


    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private List<String> sortByTypes;

    @Autowired
    private StudentMapper mapper;

    /*
        1. 学生可以查看题目，题型，分数，截止时间，知识点，解析（可选），答案（可选），成绩，总成绩
        2. 学生可以填写回答
        3. 学生测试结果使用redis保存 hashMap
        4. reply:testId:id:questionId:
    */
    public void reply(String testId, String uid, StudentReply studentReply) {
        mapper.insertOrUpdateReply(testId, uid, studentReply.getQuestionId(), studentReply.getQuestionAnswer());
        // 学生的回答 可以使用字符串存
        // 使用Redis
//        for (StudentReply studentReply : studentReplies) {
//            StringBuilder key = new StringBuilder(testId).append(":").append(uid).append(":").append(studentReply.getQuestionId());
//            redisTemplate.opsForValue().set(key.toString(), studentReply.getQuestionAnswer());
//        }
//        StringBuilder key = new StringBuilder(testId).append(":").append(uid).append(":").append(studentReply.getQuestionId());
//        redisTemplate.opsForValue().set(key.toString(), studentReply.getQuestionAnswer());

    }


    // 学生获取测试题 以及答题情况,未包含答案
    public HashMap<String, Object> studentGetAllQuestionById(String testId, String uid) {
        List<String> types = sortByTypes;
        List<Question> questions = mapper.studentGetAllQuestionById(testId, types);
        List<StudentReply> studentReplies = new ArrayList<>();
        for (Question question : questions) {
            studentReplies.add(new StudentReply(question, mapper.getQuestionAnswer(question.getQuestionId())));
        }


        //HashMap<String, Object> result = new HashMap<>();
        //  result.put("questions", questions);

//        Set<String> sets = redisTemplate.keys(testId + ":" + uid + "*");
//        List<Object> replies = redisTemplate.opsForValue().multiGet(sets);
//
//        result.put("answer", replies);

        //System.out.println(redisTemplate.keys(testId + "*"));
        return ResultMap.setResult("200", studentReplies, "学生");
    }

}
