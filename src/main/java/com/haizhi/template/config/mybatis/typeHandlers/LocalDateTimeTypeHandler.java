package com.haizhi.template.config.mybatis.typeHandlers;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * Create by liuyu
 * Date is 2019-11-14
 * Description is : mybatis 结果类型映射，JdbcType.TIMESTAMP to JAVA.LocalDateTime
 */
@MappedTypes(LocalDateTime.class)
@MappedJdbcTypes(JdbcType.TIMESTAMP)
public class LocalDateTimeTypeHandler implements TypeHandler<LocalDateTime> {

    @Override
    public void setParameter(PreparedStatement ps, int i, LocalDateTime parameter, JdbcType jdbcType) throws SQLException {
        ps.setTimestamp(i,localToStamp(parameter));
    }

    @Override
    public LocalDateTime getResult(ResultSet rs, String columnName) throws SQLException {
        return stampToLocal(rs.getTimestamp(columnName));
    }

    @Override
    public LocalDateTime getResult(ResultSet rs, int columnIndex) throws SQLException {
        return stampToLocal(rs.getTimestamp(columnIndex));
    }

    @Override
    public LocalDateTime getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return stampToLocal(cs.getTimestamp(columnIndex));
    }

    private Timestamp localToStamp(LocalDateTime localDateTime){
        return new Timestamp(localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
    }

    private LocalDateTime stampToLocal(Timestamp timestamp){
        return LocalDateTime.ofInstant(timestamp.toInstant(), ZoneId.of("+8"));
    }

}
