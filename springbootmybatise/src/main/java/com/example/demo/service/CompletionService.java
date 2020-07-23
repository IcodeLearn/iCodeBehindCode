package com.example.demo.service;

import com.example.demo.entity.Completion;
import com.example.demo.mapper.CompletionMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompletionService {

    @Autowired
    private CompletionMapper mapper;

    public Completion findCompletionByText(@Param("text") String completionText, @Param("id") String sourceId) {
        return mapper.findCompletionByText(completionText, sourceId);
    }

    public void insertCompletion(Completion completion) {
        mapper.insertCompletion(completion);
    }
}
