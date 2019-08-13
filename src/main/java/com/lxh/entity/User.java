package com.lxh.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer Id;
    private String uname;
    private String pwd;
    private String email;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public User(Integer id, String uname, String pwd, String email) {
        Id = id;
        this.uname = uname;
        this.pwd = pwd;
        this.email = email;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return Id;
    }

    public String getUname() {
        return uname;
    }

    public String getPwd() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }
}
