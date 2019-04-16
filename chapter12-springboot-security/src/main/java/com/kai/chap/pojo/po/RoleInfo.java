package com.kai.chap.pojo.po;

/**
 * 用户角色实体类
 * @author hok
 * @since 2019-4-4 16:38:49
 */
public class RoleInfo {

    private Long id;
    /**
     * 角色名称
     */
    private String roleName;
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
