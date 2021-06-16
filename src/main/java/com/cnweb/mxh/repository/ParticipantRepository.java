package com.cnweb.mxh.repository;

import com.cnweb.mxh.model.Participant;

import java.util.List;

public interface ParticipantRepository extends BaseRepository<Participant>{
    Integer insert(Participant participant);
    void update(Participant participant);
    Participant findById(int id);
    List<Participant> findAll();
    Participant findByConversationIdAndUserId(int conversation_id, int user_id);

}
