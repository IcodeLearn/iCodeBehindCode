package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void userRegister(User user);

    User findUserByTel(String tel);

    User getUserLoginInformation(String tel);

}
