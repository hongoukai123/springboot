package com.kai.chap.pojo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * 角色实体类
 * 用户Document注解标注此类为MongoDB文档
 * @author hok
 * @since 2019-3-21 16:09:04
 */
@Document
public class RoleInfo implements Serializable {

    private static final long serialVersionUID = 1890536703537585360L;

    private Long id;

    /**
     * 角色名称
     * 注解Field代表MongoDB中属性命名为role_name
     */
    @Field("role_name")
    private String roleName;

    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
