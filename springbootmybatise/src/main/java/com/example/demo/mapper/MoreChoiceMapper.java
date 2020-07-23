package com.example.demo.mapper;

import com.example.demo.entity.MoreChoice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MoreChoiceMapper {

    MoreChoice findMoreChoiceByText(@Param("text") String moreText, @Param("id") String sourceId);

    void insertMoreChoice(MoreChoice moreChoice);
}
