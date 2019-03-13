package com.kai.chap.pojo;

import com.kai.chap.converter.SexConverter;
import com.kai.chap.enumeration.SexEnum;

import javax.persistence.*;

/**
 * 用户信息类
 * @author hok
 * @since 2019-3-11 16:26:48
 */
@Entity(name = "user")  //标明是一个实体类
@Table(name = "t_user") //定义映射的表
public class User {

    @Id     //标明主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键策略递增
    private Long id;

    @Column(name = "user_name") //定义属性和表的映射关系
    private String userName;

    @Convert(converter = SexConverter.class)  //定义转换器
    private SexEnum sex;

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
