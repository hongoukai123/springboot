package com.kai.chap.pojo;

import org.apache.ibatis.type.Alias;

/**
 * 用户信息类
 * @author hok
 * @since 2019-3-14 14:10:03
 */
@Alias(value = "userInfo")
public class UserInfo {

    private Integer id;

    private String userName;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return this.id + "----" + this.userName + "----" + this.note;
    }
}
