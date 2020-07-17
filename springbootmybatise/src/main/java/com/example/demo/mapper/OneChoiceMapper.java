package com.example.demo.mapper;

import com.example.demo.entity.OneChoice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OneMapper {
    OneChoice findOneChoiceByText(String oneText);
}
