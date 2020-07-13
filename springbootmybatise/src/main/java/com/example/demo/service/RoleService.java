package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public HashMap<String, Object> roleRegister(Role role) {
        if(roleMapper.findRoleByRoleName(role.getRoleName()) != null) {
            return ResultMap.setResult("401", null, "该角色已经存在！");
        }

        role.setRoleId(UUID.randomUUID().toString());
        role.setRoleName(role.getRoleName());

        roleMapper.roleRegister(role);
        return ResultMap.setResult("200", null, "角色增加成功");
    }

    public HashMap<String, Object> getAllRole() {
        List<Role> roles = roleMapper.getAllRole();
        return ResultMap.setResult("200", roles, "角色列表");
    }
}
