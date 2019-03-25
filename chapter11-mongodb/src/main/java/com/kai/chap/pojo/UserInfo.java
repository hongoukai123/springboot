package com.kai.chap.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

/**
 * 用户实体类
 * 注解Document,标识此类为MongoDB文档
 * @author hok
 * @since 2019-3-21 15:49:17
 */
@Document
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 2782604704377586610L;

    /**
     * MongoDB文档编号，主键
     */
    @Id
    private Long id;

    /**
     * MongoDB中使用user_name保存属性
     */
    @Field("user_name")
    private String userName;

    private String note;

    /**
     * 角色列表
     */
    private List<RoleInfo> roleInfos;

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

    public List<RoleInfo> getRoleInfos() {
        return roleInfos;
    }

    public void setRoleInfos(List<RoleInfo> roleInfos) {
        this.roleInfos = roleInfos;
    }
}
