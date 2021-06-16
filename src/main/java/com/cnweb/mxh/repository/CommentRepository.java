package com.cnweb.mxh.repository;

import com.cnweb.mxh.model.Comment;

import java.util.List;

public interface CommentRepository extends BaseRepository<Comment>{
    Integer insert(Comment comment);
    void update(Comment comment);
    Comment findById(int id);
    List<Comment> findAll();
}
