package com.cnweb.mxh.repository.impl;

import com.cnweb.mxh.mapper.MessageMapper;
import com.cnweb.mxh.model.Message;
import com.cnweb.mxh.repository.MessageRepository;

import java.sql.Timestamp;
import java.util.List;

public class MessageRepositoryImpl extends AbstractRepository<Message> implements MessageRepository {
    private String sql;
    @Override
    public Integer insert(Message message) {
        sql = "insert into message(conversation_id, user_id, content, created_time, status) values(?, ?, ?, ?, ?)";
        return insert(sql, message.getConversation_id(), message.getUser_id(), message.getContent(), new Timestamp(System.currentTimeMillis()), true);
    }

    @Override
    public void update(Message message) {
        sql = "update message set conversation_id = ?, user_id = ?, content = ?, created_time = ?, status = ? where id = ?";
        update(sql, message.getConversation_id(), message.getUser_id(), message.getContent(), new Timestamp(System.currentTimeMillis()), true, message.getId());
    }

    @Override
    public Message findById(int id) {
        sql = "select * from message where id = ?";
        List<Message> messages = query(sql, new MessageMapper(), id);
        return messages.isEmpty() ? null : messages.get(0);
    }

    @Override
    public List<Message> findAll() {
        sql = "select * from message";
        return query(sql, new MessageMapper());
    }

    @Override
    public Message findByConversationIdAndUserId(int conversation_id, int user_id) {
        sql = "select * from message where conversation_id = ? and user_id = ?";
        List<Message> messages = query(sql, new MessageMapper(), conversation_id, user_id);
        return messages.isEmpty() ? null : messages.get(0);
    }
}
