package com.cnweb.mxh.repository;

import com.cnweb.mxh.model.React;

import java.util.List;


public interface ReactRepository extends BaseRepository<React>{
    Integer insert(React react);
    void update(React react);
    React findById(int id);
    List<React> findAll();
    React findByPostIdAndUserId(int post_id, int user_id);
}
