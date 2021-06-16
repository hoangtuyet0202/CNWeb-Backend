package com.cnweb.mxh.repository;

import com.cnweb.mxh.model.User;

import java.util.List;

public interface UserRepository extends BaseRepository<User>{
    Integer insert(User user);
    void update(User user);
    User findById(int id);
    List<User> findAll();
}
