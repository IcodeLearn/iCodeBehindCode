package com.example.demo.mapper;

import com.example.demo.entity.Source;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SourceMapper {
    // 增加题库
    void createSource(Source source);

    Source findSourceByTeacherAndCourse(@Param("courseId") String courseId,
                                        @Param("uid") String uid);

    void updateSourceById(Source source);

    Source findBySourceById(String sourceId);
}
