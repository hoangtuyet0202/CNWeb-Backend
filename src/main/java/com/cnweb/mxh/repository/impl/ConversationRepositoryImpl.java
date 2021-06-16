package com.cnweb.mxh.repository.impl;

import com.cnweb.mxh.mapper.ConversationMapper;
import com.cnweb.mxh.model.Conversation;
import com.cnweb.mxh.repository.ConversationRepository;

import java.sql.Timestamp;
import java.util.List;


public class ConversationRepositoryImpl extends AbstractRepository<Conversation> implements ConversationRepository {
    private String sql;
    @Override
    public Integer insert(Conversation conversation) {
        sql = "insert into conversation(title, created_time) values(?, ?)";
        return insert(sql, conversation.getTitle(), new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public void update(Conversation conversation) {
        sql = "update conversation set title = ?, created_time = ? where id = ?";
        update(sql, conversation.getTitle(), new Timestamp(System.currentTimeMillis()), conversation.getId());
    }

    @Override
    public Conversation findById(int id) {
        sql = "select * from conversation where id = ?";
        List<Conversation> conversations = query(sql, new ConversationMapper(), id);
        return conversations.isEmpty() ? null : conversations.get(0);
    }

    @Override
    public List<Conversation> findAll() {
        sql = "select * from conversation";
        return query(sql, new ConversationMapper());
    }
}
