package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public HashMap<String, Object> userRegister(@RequestBody User user) {
        return userService.userRegister(user);
    }

    @GetMapping("/test")
    public String test() {
        return "测试成功！";
    }


}
