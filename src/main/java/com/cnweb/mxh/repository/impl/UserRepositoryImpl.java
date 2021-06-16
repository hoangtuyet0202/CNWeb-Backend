package com.cnweb.mxh.repository.impl;

import com.cnweb.mxh.mapper.UserMapper;
import com.cnweb.mxh.model.User;
import com.cnweb.mxh.repository.UserRepository;

import java.util.List;


public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {
    private String sql;
    @Override
    public Integer insert(User user) {
        sql = "insert into user(username, password, role, firstname, lastname, gender, email, birthday, avatar) values( ?, ?, ?, ?, ?, ?, ?, ?, null)";
        return insert(sql, user.getUsername(), user.getPassword(),user.getRole(), user.getFirstname(),user.getLastname(),user.getGender(),user.getEmail(),user.getBirthday());
    }

    @Override
    public void update(User user) {
        sql = "update user set username = ?, password = ?, role = ?, firstname = ?, lastname = ?, gender = ?, email = ?, birthday = ?, avatar = ? where id = ?";
        update(sql, user.getUsername(), user.getPassword(), user.getRole(), user.getFirstname(), user.getLastname(), user.getGender(), user.getEmail(), user.getBirthday(), user.getAvatar(), user.getId());
    }

    @Override
    public User findById(int id) {
        sql = "select * from user where id = ?";
        List<User> users = query(sql, new UserMapper(), id);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public List<User> findAll() {
        sql = "select * from user";
        return query(sql, new UserMapper());
    }
}
