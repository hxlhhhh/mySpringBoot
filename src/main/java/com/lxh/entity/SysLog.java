package com.lxh.entity;

import java.io.Serializable;

public class SysLog implements Serializable {
 
    private static final long serialVersionUID = 2713975405735052081L;
 
    private Integer logId;//日志ID
    private String userName;//用户名字
    private String userIp;//用户IP
    private String requestMethod;//请求方法
    private String requestDesc;//方法描述
    private String createTime;//记录日期

    @Override
    public String toString() {
        return "SysLog{" +
                "logId=" + logId +
                ", userName='" + userName + '\'' +
                ", userIp='" + userIp + '\'' +
                ", requestMethod='" + requestMethod + '\'' +
                ", requestDesc='" + requestDesc + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestDesc() {
        return requestDesc;
    }

    public void setRequestDesc(String requestDesc) {
        this.requestDesc = requestDesc;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}