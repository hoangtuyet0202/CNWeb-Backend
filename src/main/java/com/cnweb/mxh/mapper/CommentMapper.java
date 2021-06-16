package com.cnweb.mxh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cnweb.mxh.model.Comment;

public class CommentMapper implements RowMapper<Comment>{

    @Override
    public Comment mapRow(ResultSet rs) {
        try {
            Comment comment = new Comment();
            comment.setId(rs.getInt("id"));
            comment.setPost_id(rs.getInt("post_id"));
            comment.setUser_id(rs.getInt("user_id"));
            comment.setContent(rs.getString("content"));
            comment.setCreated_time(rs.getTimestamp("created_time"));
            comment.setStatus(rs.getBoolean("status"));
            return comment;
        } catch (SQLException e) {
            return null;
        }
    }
}
