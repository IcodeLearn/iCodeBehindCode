package com.example.demo;

import com.example.demo.entity.Question;
import com.example.demo.entity.QuestionLinkPoint;
import com.example.demo.entity.StudentReply;
import com.example.demo.service.KnowledgePointService;
import com.example.demo.service.KnowledgeService;
import com.example.demo.service.QuestionService;
import com.example.demo.service.TestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootTest
class SpringbootmybatisApplicationTests {

    @Autowired
    private KnowledgeService service;

    @Autowired
    private TestService testService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private KnowledgePointService knowledgePointService;

    @Autowired
    //@Qualifier("redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test() {
       // StringBuilder builder = new StringBuilder("/");
        List<QuestionLinkPoint> links = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        links.add(new QuestionLinkPoint("123", ids));

        links.add(new QuestionLinkPoint("456", ids));

        service.questionLinkToKnowledgePoint(links);
    }

    @Test
    public void testService() {

//        String regx = "/"+ 2 +"/|/"+2+"$";
//        List<Integer> questionIds = knowledgePointService.getChild(regx);
//        System.out.println(questionIds.toString());
        List<Question> list = questionService.findAllQuestionById("cc431144-649c-4c94-949b-1160c96dfe81");
        for (Question question : list) {
            System.out.println(question.getQuestionType());
        }

    }

    @Test
    void redisTest() {
        //redisTemplate.opsForValue().set("mykey", "hello");
        //System.out.println(redisTemplate.opsForValue().get("mykey"));
        redisTemplate.opsForValue().set("usr:test1:question1", "m");
        redisTemplate.opsForValue().set("test", "x");
        redisTemplate.opsForValue().set("hello", "y");

        //System.out.println(redisTemplate.opsForValue().get("helo"));
        Set<String> set = redisTemplate.keys("usr:" + "*");
        //System.out.println(redisTemplate.keys("*"));
        assert set != null;
        System.out.println(set.size());
        System.out.println(set);
        //System.out.println(redisTemplate.keys("*"));
        //System.out.println(redisTemplate.opsForValue().get("hello"));
        // System.out.println(redisTemplate.keys("he*"));
//        long s1 = System.currentTimeMillis();
//        addString();
//        long e1 = System.currentTimeMillis();
//        System.out.println("addString 执行时间: " + (e1 - s1) + "毫秒");
//
//        long s2 = System.currentTimeMillis();
//        add();
//        long e2 = System.currentTimeMillis();
//        System.out.println("add执行时间: " + (e2 - s2) + "毫秒");
    }
    
    public void addString() {
        String test = "";
        for (int i = 0; i < 10000; i++) {
            test = test + "a";
        }
    }
    
    public void add() {
        String test;
        StringBuilder builder = null;
        for (int i = 0; i < 10000; i++) {
           builder = new StringBuilder("test");
           builder.append("a");
        }
        test = builder.toString();
    }

    @Test
    public void testObject() throws JsonProcessingException {

        ObjectMapper om = new ObjectMapper();
        //om.writeValueAsString(new StudentReply("1", "hello"));

        redisTemplate.opsForValue().set("test", new StudentReply("1", "hello"));

        //StudentReply studentReply = (StudentReply) redisTemplate.opsForValue().get("test");
        //System.out.println(studentReply.getQuestionId());
        System.out.println(redisTemplate.opsForValue().get("test"));

        System.out.println(new ObjectMapper().writeValueAsString(redisTemplate.opsForValue().get("test")));
    }
}
