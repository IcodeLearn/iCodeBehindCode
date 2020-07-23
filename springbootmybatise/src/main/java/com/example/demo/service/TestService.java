package com.example.demo.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    public void test(@Param("id")String id, @Param("value") String value) {
        System.out.println("value: " + value);
        System.out.println("id: " + id);
    }
}
