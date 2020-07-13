package com.example.demo;

import com.example.demo.mapper.UserMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.xml.bind.DatatypeConverter;
import java.util.Date;

@SpringBootTest
class SpringbootmybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(userMapper.getUserLoginInformation("xxxx"));
        System.out.println(new Date(System.currentTimeMillis()));
        //验证和读取JWT的示例方法

        String jwt = "eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJndWFuZ21pbmdkZXhpbiIsInN1YiI6Inh4eHgiLCJpYXQiOjE1OTQ2MjgzOTgsImV4cCI6MTU5NDYzMTk5OH0.nJ8yFsTYSQFEYmS4EWdC1bFYXwzR_BKpoprqk1QiWErEI_mJ8NFGUMaw38iBseE120OroZVy9kyYGzuwZGSgKw";
            //如果它不是签名的JWS（如预期的那样），则该行将抛出异常
            Claims claims = Jwts.parser()
                    .setSigningKey("iCode")
                    .parseClaimsJws(jwt).getBody();
            System.out.println("ID: " + claims.getId());
            System.out.println("Subject: " + claims.getSubject());
            System.out.println("Issuer: " + claims.getIssuer());
            System.out.println("Expiration: " + claims.getExpiration());
            //claims.get("name") //获取自定义的信息


    }

}
