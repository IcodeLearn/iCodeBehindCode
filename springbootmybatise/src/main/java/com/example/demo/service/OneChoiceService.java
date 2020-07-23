package com.example.demo.service;

import com.example.demo.entity.OneChoice;
import com.example.demo.mapper.OneChoiceMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OneChoiceService {

    @Autowired
    private OneChoiceMapper oneChoiceMapper;

    public OneChoice findOneChoiceByText(@Param("text") String oneText, @Param("id") String sourceId) {
        return oneChoiceMapper.findOneChoiceByText(oneText, sourceId);
    }

    public void insertOneChoice(OneChoice oneChoice) {
        oneChoiceMapper.insertOneChoice(oneChoice);
    }
}
