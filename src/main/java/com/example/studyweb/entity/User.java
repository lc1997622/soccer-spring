package com.example.studyweb.entity;

public class User {
    private String userid;
    private String username;
    private String password;
    private String tel;


    public String getUserid() {
        return userid;
    }

    public String getTel() {
        return tel;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
