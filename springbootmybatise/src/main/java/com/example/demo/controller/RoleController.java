package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/role/register")
    public HashMap<String, Object> roleRister(@RequestBody Role role) {
        return roleService.roleRegister(role);
    }

    @GetMapping("/roles")
    public HashMap<String, Object> getAllRoles() {
        return roleService.getAllRole();
    }
}
