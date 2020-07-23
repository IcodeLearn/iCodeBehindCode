package com.example.demo.service;

import com.example.demo.entity.MoreChoice;
import com.example.demo.mapper.MoreChoiceMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoreChoiceService {

    @Autowired
    private MoreChoiceMapper mapper;

    public MoreChoice findMoreChoiceByText(@Param("text") String moreText, @Param("id") String sourceId) {
        return mapper.findMoreChoiceByText(moreText, sourceId);
    }


    public void insertMoreChoice(MoreChoice moreChoice) {
        mapper.insertMoreChoice(moreChoice);
    }
}
