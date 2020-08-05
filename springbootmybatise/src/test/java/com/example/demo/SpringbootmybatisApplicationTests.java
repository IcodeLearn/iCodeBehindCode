package com.example.demo;

import com.example.demo.entity.QuestionLinkPoint;
import com.example.demo.service.KnowledgeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringbootmybatisApplicationTests {

    @Autowired
    private KnowledgeService service;

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
}
