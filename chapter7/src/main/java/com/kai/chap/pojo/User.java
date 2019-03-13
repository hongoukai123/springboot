package com.kai.chap.pojo;

import com.kai.chap.enumeration.SexEnum;
import org.apache.ibatis.type.Alias;

/**
 * 用户信息实体类
 * @author hok
 * @since 2019-3-13 16:07:09
 */
@Alias(value = "user")  //mybatis指定别名用于UserMapper.xml配置文件
public class User {

    /**
     * id
     */
    private int id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 性别枚举
     */
    private SexEnum sex;

    /**
     * 别名
     */
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
