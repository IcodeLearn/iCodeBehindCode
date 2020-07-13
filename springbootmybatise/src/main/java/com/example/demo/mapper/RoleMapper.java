package com.example.demo.mapper;

import com.example.demo.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    void roleRegister(Role role);

    Role findRoleByRoleName(String roleName);

    List<Role> getAllRole();
}
