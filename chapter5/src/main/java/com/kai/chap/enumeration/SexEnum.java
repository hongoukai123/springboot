package com.kai.chap.enumeration;

/**
 * 性别枚举类
 * @author hok
 * @since 2019-3-11 11:41:14
 */
public enum SexEnum {

    MALE(1, "男"),
    FEMALE(2, "女");

    private int id;

    private String name;

    SexEnum(int id, String name){
        this.id = id;
        this.name = name;
    }

    /**
     * 通过id获取枚举key获取value值（如上面：通过1,2可以获取男，女）
     * @param id
     * @return
     */
    public static SexEnum getEnumById(int id){
        for (SexEnum sex : SexEnum.values()){
            if (sex.getId() == id){
                return sex;
            }
        }
        return null;
    }

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

}
