package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/teacher/courses")
    public String creatCourse() {
        return "新增了一门课程！";
    }

    @DeleteMapping("/teacher/courses/{id}")
    public String deleteCourseById(@PathVariable String id) {
        return "删除了一门课程！";
    }

    @PostMapping("/student/courses")
    public String createSTCourse() {
        return "我是学生，新添加了一门课程";
    }


}
