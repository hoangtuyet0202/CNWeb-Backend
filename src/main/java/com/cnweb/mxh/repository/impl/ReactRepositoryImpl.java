package com.cnweb.mxh.repository.impl;

import java.sql.Timestamp;
import java.util.List;

import com.cnweb.mxh.mapper.ReactMapper;
import com.cnweb.mxh.model.React;
import com.cnweb.mxh.repository.ReactRepository;


public class ReactRepositoryImpl extends AbstractRepository<React> implements ReactRepository {
    private String sql;
    @Override
    public Integer insert(React react) {
        sql = "insert into react(post_id, user_id, created_time, status) values(?, ?, ?, ?)";
        return insert(sql, react.getPost_id(), react.getUser_id(), new Timestamp(System.currentTimeMillis()), react.getStatus());
    }

    @Override
    public void update(React react) {
        sql = "update react set created_time = ?, status = ? where post_id = ? and user_id = ?";
        update(sql, react.getCreated_time(), react.getStatus(), react.getPost_id(), react.getUser_id());
    }

    @Override
    public React findById(int id) {
        sql = "select * from react where id = ?";
        List<React> reacts = query(sql, new ReactMapper(), id);
        return reacts.isEmpty() ? null : reacts.get(0);
    }

    @Override
    public List<React> findAll() {
        sql = "select * from react";
        return query(sql, new ReactMapper());
    }

    @Override
    public React findByPostIdAndUserId(int post_id, int user_id) {
        sql = "select * from react where post_id = ? and user_id = ?";
        List<React> reacts = query(sql, new ReactMapper(), post_id, user_id);
        return reacts.isEmpty() ? null : reacts.get(0);
    }
}
