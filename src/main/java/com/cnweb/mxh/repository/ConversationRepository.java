package com.cnweb.mxh.repository;

import com.cnweb.mxh.model.Conversation;

import java.util.List;

public interface ConversationRepository extends BaseRepository<Conversation>{
    Integer insert(Conversation conversation);
    void update(Conversation conversation);
    Conversation findById(int id);
    List<Conversation> findAll();
}
