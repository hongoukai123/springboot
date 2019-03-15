package com.kai.chap.service.impl;

import com.kai.chap.service.IJdbcService;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * jdbc实现访问数据库（事务处理）
 * @author hok
 * @since 2019-3-14 11:08:25
 */
@Service("jdbcService")
public class JdbcServiceImpl implements IJdbcService {

    @Autowired
    private DataSource dataSource;

    @Override
    public int insertUser(String userName, String note) {
        //定义数据库连接对象
        Connection connection = null;
        //返回结果
        int result = 0;
        try {
            //获取连接
            connection = dataSource.getConnection();
            //开启事务
            connection.setAutoCommit(false);
            //设置隔离级别
            connection.setTransactionIsolation(TransactionIsolationLevel.READ_COMMITTED.getLevel());
            //执行SQL
            PreparedStatement ps = connection.prepareStatement("insert into t_user(user_name, note) values (?, ?)");
            ps.setString(1, userName);
            ps.setString(2, note);
            result = ps.executeUpdate();
            //提交事务
            connection.commit();
        } catch (SQLException e) {
            //回滚事务
            if(connection != null){
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            try {
                if (connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
