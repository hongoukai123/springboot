package com.kai.chap.pojo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 用户实体类
 * @author hok
 * @since 2019-3-20 15:56:59
 */
@Alias("userInfo")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 2782604704377586610L;

    private Long id;

    private String userName;

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
