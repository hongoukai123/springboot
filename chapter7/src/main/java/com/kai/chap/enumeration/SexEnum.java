package com.kai.chap.enumeration;

/**
 * 性别枚举类
 * @author hok
 * @since 2019-3-13 16:08:23
 */
public enum SexEnum {

    MALE(1, "男"),
    FEMALE(2, "女");

    /**
     * 数字性别符（例：1,2）
     */
    private int id;

    /**
     * 性别中文描述（例：男，女）
     */
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    SexEnum(int id, String name){
        this.id = id;
        this.name = name;
    }

    /**
     * 通过id获取枚举对象
     * @param id
     * @return
     */
    public static SexEnum getSexEnum(int id){
        for (SexEnum sex : SexEnum.values()){
            if (sex.getId() == id){
                return sex;
            }
        }
        return null;
    }

}
