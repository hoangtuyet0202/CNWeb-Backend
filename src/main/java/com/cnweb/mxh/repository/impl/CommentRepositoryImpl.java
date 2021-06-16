package com.cnweb.mxh.repository.impl;

import com.cnweb.mxh.mapper.CommentMapper;
import com.cnweb.mxh.model.Comment;
import com.cnweb.mxh.repository.CommentRepository;

import java.sql.Timestamp;
import java.util.List;

public class CommentRepositoryImpl extends AbstractRepository<Comment> implements CommentRepository {

    private String sql;
    @Override
    public Integer insert(Comment comment) {
        sql = "insert into comment(post_id, user_id, content, created_time, status) values(?, ?, ?, ?, ?)";
        return insert(sql, comment.getPost_id(), comment.getUser_id(), comment.getContent(), new Timestamp(System.currentTimeMillis()), comment.getStatus());
    }

    @Override
    public void update(Comment comment) {
        sql = "update comment set content = ?, created_time = ?, status = ? where id = ?";
        update(sql, comment.getContent(), new Timestamp(System.currentTimeMillis()), comment.getStatus(), comment.getId());
    }

    @Override
    public Comment findById(int id) {
        sql = "select * from comment where id = ?";
        List<Comment> comments = query(sql, new CommentMapper(), id);
        return comments.isEmpty() ? null : comments.get(0);
    }

    @Override
    public List<Comment> findAll() {
        sql = "select * from comment";
        return query(sql, new CommentMapper());
    }
}
