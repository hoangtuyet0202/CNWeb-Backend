package com.cnweb.mxh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cnweb.mxh.model.Conversation;

public class ConversationMapper implements RowMapper<Conversation>{
    @Override
    public Conversation mapRow(ResultSet rs) {
        try {
            Conversation conversation = new Conversation();
            conversation.setId(rs.getInt("id"));
            conversation.setTitle(rs.getString("title"));
            conversation.setCreated_time(rs.getTimestamp("created_time"));
            return conversation;
        } catch (SQLException e) {
            return null;
        }
    }
}
