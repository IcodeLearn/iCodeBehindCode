package com.example.demo.service;

import com.example.demo.entity.JwtUser;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册
     * @param user 用户对象
     * @return
     */
    public HashMap<String, Object> userRegister(User user) {
        user.setUid(UUID.randomUUID().toString());
        user.setUpassword(new BCryptPasswordEncoder().encode(user.getUpassword()));
        if(user.getTel() == null) {
            return ResultMap.setResult("10003", null, "缺少电话号码");
        }
        // 判断电话是否重复
        User u = userMapper.findUserByTel(user.getTel());
        if(u != null) {
            return ResultMap.setResult("10001", null, "电话号码重复");
        }
        userMapper.userRegister(user);
        return ResultMap.setResult("200", null, "注册成功");
    }

    /**
     * 根据用户名查找用户
     * @param username 用户名（电话，邮箱）
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUserLoginInformation(username);
        if(user == null) {
            return new JwtUser();
        }
        return new JwtUser(user);
    }
}
