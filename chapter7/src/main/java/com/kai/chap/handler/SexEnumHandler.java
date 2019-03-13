package com.kai.chap.handler;

import com.kai.chap.enumeration.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 性别枚举转换器
 * @author hok
 * @since 2019-3-13 16:16:44
 */
@MappedJdbcTypes(JdbcType.INTEGER)  //声明JdbcType为整型
@MappedTypes(value = SexEnum.class) //声明JavaType为SexEnum
public class SexEnumHandler extends BaseTypeHandler<SexEnum> {

    /**
     * 设置非空性别参数
     * @param ps
     * @param i
     * @param parameter
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getId());
    }

    /**
     * 通过列名读取性别
     * @param rs
     * @param columnName
     * @return
     * @throws SQLException
     */
    @Override
    public SexEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int sex = rs.getInt(columnName);
        if(sex != 1 && sex != 2){
            return null;
        }
        return SexEnum.getSexEnum(sex);
    }

    /**
     * 通过下标读取性别
     * @param rs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public SexEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int sex = rs.getInt(columnIndex);
        if(sex != 1 && sex != 2){
            return null;
        }
        return SexEnum.getSexEnum(sex);
    }

    /**
     * 通过存储过程读取性别
     * @param cs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public SexEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int sex = cs.getInt(columnIndex);
        if(sex != 1 && sex != 2){
            return null;
        }
        return SexEnum.getSexEnum(sex);
    }

}
