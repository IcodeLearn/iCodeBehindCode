package com.example.demo.mapper;

import com.example.demo.entity.OneChoice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OneChoiceMapper {
    OneChoice findOneChoiceByText(@Param("text") String oneText, @Param("id") String sourceId);

    void insertOneChoice(OneChoice oneChoice);

    void updateOneChoice(String oneId);

    void deleteOneChoice(String oneId);
}
