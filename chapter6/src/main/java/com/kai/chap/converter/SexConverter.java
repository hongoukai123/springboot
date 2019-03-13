package com.kai.chap.converter;

import com.kai.chap.enumeration.SexEnum;

import javax.persistence.AttributeConverter;

/**
 * 性别转换器
 * <p>
 *     AttributeConverter（实现了由对象转换成属性，由属性转换成对象）
 *     这个类定义了：从数据库读出的转换规则和从属性转换为数据库列的规则，
 *     从而将枚举类与数据库的列对应起来。
 * </p>
 * @author hok
 * @since 2019-3-11 16:41:21
 */
public class SexConverter implements AttributeConverter<SexEnum, Integer> {

    /**
     * 将枚举转换成数据库列
     * @param sexEnum 枚举对象
     * @return
     */
    @Override
    public Integer convertToDatabaseColumn(SexEnum sexEnum) {
        return sexEnum.getId();
    }

    /**
     * 将数据库列转换成枚举
     * @param id
     * @return
     */
    @Override
    public SexEnum convertToEntityAttribute(Integer id) {
        return SexEnum.getEnumById(id);
    }

}
