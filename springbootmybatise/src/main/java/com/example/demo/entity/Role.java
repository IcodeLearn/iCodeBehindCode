package com.example.demo.entity;

public class Role {
    // 角色ID
    private String roleId;

    // 角色名
    private String roleName;

    // 角色中文名
    private String roleZN;

    public String getRoleZN() {
        return roleZN;
    }

    public void setRoleZN(String roleZN) {
        this.roleZN = roleZN;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
