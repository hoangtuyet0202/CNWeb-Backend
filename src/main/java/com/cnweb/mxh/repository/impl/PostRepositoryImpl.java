package com.cnweb.mxh.repository.impl;

import com.cnweb.mxh.mapper.PostMapper;
import com.cnweb.mxh.model.Post;
import com.cnweb.mxh.repository.PostRepository;

import java.sql.Timestamp;
import java.util.List;


public class PostRepositoryImpl extends AbstractRepository<Post> implements PostRepository {
    private String sql;
    @Override
    public Integer insert(Post post) {
        sql = "insert into post( user_id, created_time, content, scope) values(?, ?, ?, ?)";
        return insert(sql, post.getUser_id(), new Timestamp(System.currentTimeMillis()), post.getContent(), post.getScope());
    }

    @Override
    public void update(Post post) {
        sql = "update post set user_id = ?, created_time = ?, content =?, scope = ? where id = ? ";
        update(sql, post.getUser_id(), new Timestamp(System.currentTimeMillis()), post.getContent(), post.getScope(), post.getId());
    }

    @Override
    public Post findById(int id) {
        sql = "select * from post where id = ?";
        List<Post> posts = query(sql, new PostMapper(), id);
        return posts.isEmpty() ? null : posts.get(0);
    }

    @Override
    public List<Post> findAll() {
        sql = "select * from post";
        return query(sql, new PostMapper());
    }
}
