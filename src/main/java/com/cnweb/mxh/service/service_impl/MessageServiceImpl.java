package com.cnweb.mxh.service.service_impl;

import com.cnweb.mxh.model.Message;
import com.cnweb.mxh.repository.MessageRepository;
import com.cnweb.mxh.repository.impl.MessageRepositoryImpl;
import com.cnweb.mxh.service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    private MessageRepository messageRepository = new MessageRepositoryImpl();

    @Override
    public Message insert(Message message) {
        int id = messageRepository.insert(message);
        return messageRepository.findById(id);
    }

    @Override
    public Message update(Message message) {
        messageRepository.update(message);
        return messageRepository.findById(message.getId());
    }

    @Override
    public Message findById(int id) {
        return messageRepository.findById(id);
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }
}
