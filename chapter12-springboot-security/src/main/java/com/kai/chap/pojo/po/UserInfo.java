package com.kai.chap.pojo.po;

import org.apache.ibatis.type.Alias;

/**
 * 用户实体类
 * @author hok
 * @since 2019-4-4 16:40:36
 */
@Alias(value = "userInfo")
public class UserInfo {

    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 是否可用（1表示可用，0表示不可用）
     */
    private int available;
    /**
     * 描述
     */
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
