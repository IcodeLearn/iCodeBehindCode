package com.example.demo.controller;

import com.example.demo.service.SourceService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@RestController
public class SourceController {

    @Autowired
    private SourceService sourceService;

    @PostMapping("/teacher/source")
    public HashMap<String, Object> createSource(MultipartFile uploadFile, @Param("courseId") String courseId, @Param("uid") String uid) {
        return sourceService.createSource(uploadFile, courseId, uid);
    }
}
