package com.kai.chap.service.impl;

import com.kai.chap.enumeration.SexEnum;
import com.kai.chap.pojo.User;
import com.kai.chap.service.JdbcTmplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

@Service
public class JdbcTmplUserServiceImpl  implements JdbcTmplUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 获取映射关系
     * @return
     */
    public RowMapper<User> getUserMapper(){
        //使用Lambda表达式创建映射关系
        RowMapper<User> userRowMapper = (ResultSet rs, int rownum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("user_name"));
            int sexId = rs.getInt("sex");
            SexEnum sex = SexEnum.getEnumById(sexId);
            user.setSex(sex);
            user.setNote(rs.getString("note"));
            return user;
        };
        return userRowMapper;
    }

    @Override
    public User getUser(Long id) {
        //执行sql
        String sql = "select id, user_name, sex, note from t_user where id = ?";
        //参数
        Object[] params = new Object[]{id};
        User user = jdbcTemplate.queryForObject(sql, params, getUserMapper());
        return user;
    }

    @Override
    public List<User> findUsers(String userName, String note) {
        //执行sql
        String sql = "select id, user_name, sex, note from t_user " +
                "where user_name like concat('%', ?,'%') " +
                "and note like concat('%', ?, '%')";
        //参数
        Object[] params = new Object[]{userName, note};
        //使用匿名类实现
        List<User> userList = jdbcTemplate.query(sql, params, getUserMapper());
        return userList;
    }

    @Override
    public int insertUser(User user) {
        //执行sql
        String sql = "insert into t_user(user_name, sex, note) values(?, ?, ?)";
        int num = jdbcTemplate.update(sql, user.getUserName(), user.getSex().getId(), user.getNote());
        return num;
    }

    @Override
    public int updateUser(User user) {
        //执行sql
        String sql = "update t_user set user_name = ?, sex = ?, note = ? where id = ?";
        int num = jdbcTemplate.update(sql, user.getUserName(), user.getSex().getId(), user.getNote(), user.getId());
        return num;
    }

    @Override
    public int deleteUser(Long id) {
        //执行sql
        String sql = "delete from t_user where id = ?";
        int num = jdbcTemplate.update(sql, id);
        return num;
    }
}
