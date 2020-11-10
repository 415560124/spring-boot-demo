package com.rhy.entity.typeHandler;

import com.rhy.entity.admin.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/9/28
 * @Description: com.rhy.entity.typeHandler
 * @Version:1.0
 */
//声明Jdbc类型为整型
@MappedJdbcTypes(JdbcType.INTEGER)
//声明Java类型为SexEnum
@MappedTypes(value=SexEnum.class)
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {
    //设置非空性别参数
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,sexEnum.getId());
    }

    //通过列名读取姓名
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int sex = resultSet.getInt(s);
        return SexEnum.getEnumById(sex);
    }
    //通过下标读取姓名
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int sex = resultSet.getInt(i);
        return SexEnum.getEnumById(sex);
    }
    //通过存储过程读取性别
    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int sex = callableStatement.getInt(i);
        return SexEnum.getEnumById(sex);
    }
}
