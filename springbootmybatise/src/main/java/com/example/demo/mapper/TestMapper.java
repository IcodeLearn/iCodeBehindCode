package com.example.demo.mapper;

import com.example.demo.entity.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {

    void createTest(Test test);

    List<Test> findAllTest(String courseId);


}
