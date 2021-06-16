package com.cnweb.mxh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cnweb.mxh.model.Post;

public class PostMapper implements RowMapper<Post>{
    @Override
    public Post mapRow(ResultSet rs) {
        try {
            Post post = new Post();
            post.setId(rs.getInt("id"));
            post.setUser_id(rs.getInt("user_id"));
            post.setCreated_time(rs.getTimestamp("create_time"));
            post.setContent(rs.getString("content"));
            post.setScope(rs.getInt("scope"));
            return post;
        } catch (SQLException e) {
            return null;
        }
    }
}
