package com.cnweb.mxh.repository;


import com.cnweb.mxh.model.Message;

import java.util.List;

public interface MessageRepository extends BaseRepository<Message>{
    Integer insert(Message message);
    void update(Message message);
    Message findById(int id);
    List<Message> findAll();
    Message findByConversationIdAndUserId(int conversation_id, int user_id);
}
