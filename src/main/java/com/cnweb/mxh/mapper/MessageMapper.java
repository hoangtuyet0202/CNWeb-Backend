package com.cnweb.mxh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cnweb.mxh.model.Message;

public class MessageMapper implements RowMapper<Message>{
    @Override
    public Message mapRow(ResultSet rs) {
        try {
            Message message = new Message();
            message.setId(rs.getInt("id"));
            message.setUser_id(rs.getInt("user_id"));
            message.setConversation_id(rs.getInt("conversation_id"));
            message.setContent(rs.getString("content"));
            message.setCreated_time(rs.getTimestamp("created_time"));
            message.setStatus(rs.getBoolean("status"));
            return message;
        } catch (SQLException e) {
            return null;
        }
    }
}
