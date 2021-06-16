package com.cnweb.mxh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cnweb.mxh.model.Participant;

public class ParticipantMapper implements RowMapper<Participant>{
    @Override
    public Participant mapRow(ResultSet rs) {
        try {
            Participant participant = new Participant();
            participant.setId(rs.getInt("id"));
            participant.setConversation_id(rs.getInt("conversation_id"));
            participant.setUser_id(rs.getInt("user_id"));
            participant.setStatus(rs.getBoolean("status"));
            return participant;
        } catch (SQLException e) {
            return null;
        }
    }
}
