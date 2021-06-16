package com.cnweb.mxh.service.service_impl;

import com.cnweb.mxh.model.Conversation;
import com.cnweb.mxh.repository.ConversationRepository;
import com.cnweb.mxh.repository.impl.ConversationRepositoryImpl;
import com.cnweb.mxh.service.ConversationService;

import java.util.List;

public class ConversationServiceImpl implements ConversationService {
    private ConversationRepository conversationRepository = new ConversationRepositoryImpl();

    @Override
    public Conversation insert(Conversation conversation){
        int id = conversationRepository.insert(conversation);
        return conversationRepository.findById(id);
    }

    @Override
    public Conversation update(Conversation conversation) {
        conversationRepository.update(conversation);
        return conversationRepository.findById(conversation.getId());
    }

    @Override
    public Conversation findById(int id) {
        return conversationRepository.findById(id);
    }

    @Override
    public List<Conversation> findAll() {
        return conversationRepository.findAll();
    }
}
