package com.cnweb.mxh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cnweb.mxh.model.React;

public class ReactMapper implements RowMapper<React>{
    @Override
    public React mapRow(ResultSet rs) {
        try {
            React react = new React();
            react.setId(rs.getInt("id"));
            react.setPost_id(rs.getInt("post_id"));
            react.setUser_id(rs.getInt("user_id"));
            react.setCreated_time(rs.getTimestamp("created_time"));
            react.setStatus(rs.getBoolean("status"));
            return react;
        } catch (SQLException e) {
            return null;
        }
    }
}
