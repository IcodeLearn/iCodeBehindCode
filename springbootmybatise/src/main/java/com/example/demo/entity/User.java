package com.example.demo.entity;

public class User {

    // 用户 ID
    private String uid;
    // 用户姓名
    private String uname;
    // 用户电话
    private String utel;
    // 用户性别
    private String ugender;
    // 用户密码
    private String upassword;
    // 微信号
    private String uwenvarchart;
    // 注册时的角色ID, 可修改
    private String roleId;

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", uname='" + uname + '\'' +
                ", utel='" + utel + '\'' +
                ", ugender='" + ugender + '\'' +
                ", upassword='" + upassword + '\'' +
                ", uwenvarchart='" + uwenvarchart + '\'' +
                ", roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getTel() {
        return utel;
    }

    public void setTel(String tel) {
        this.utel = tel;
    }

    public String getUgender() {
        return ugender;
    }

    public void setUgender(String ugender) {
        this.ugender = ugender;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUwenvarchart() {
        return uwenvarchart;
    }

    public void setUwenvarchart(String uwenvarchart) {
        this.uwenvarchart = uwenvarchart;
    }
}
