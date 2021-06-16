package com.cnweb.mxh.repository.impl;

import com.cnweb.mxh.mapper.ParticipantMapper;
import com.cnweb.mxh.model.Participant;
import com.cnweb.mxh.repository.ParticipantRepository;

import java.util.List;

public class ParticipantRepositoryImpl extends AbstractRepository<Participant> implements ParticipantRepository {
    private String sql;
    @Override
    public Integer insert(Participant participant) {
        sql = "insert into participant(conversation_id, user_id, status) values(?, ?, ?)";
        return insert(sql, participant.getConversation_id(), participant.getUser_id(), participant.getStatus());
    }

    @Override
    public void update(Participant participant) {
        sql = "update participant set conversation_id = ?, user_id = ?, status = ? where id = ?";
        update(sql, participant.getConversation_id(), participant.getUser_id(), participant.getStatus(), participant.getId());
    }

    @Override
    public Participant findById(int id) {
        sql = "select * from participant where id = ?";
        List<Participant> participants = query(sql, new ParticipantMapper(), id);
        return participants.isEmpty() ? null : participants.get(0);
    }

    @Override
    public List<Participant> findAll() {
        sql = "select * from participant";
        return query(sql, new ParticipantMapper());
    }

    @Override
    public Participant findByConversationIdAndUserId(int conversation_id, int user_id) {
        sql = "select * from participant where conversation_id = ? and user_id = ?";
        List<Participant> participants = query(sql, new ParticipantMapper(), conversation_id, user_id);
        return participants.isEmpty() ? null : participants.get(0);
    }
}
