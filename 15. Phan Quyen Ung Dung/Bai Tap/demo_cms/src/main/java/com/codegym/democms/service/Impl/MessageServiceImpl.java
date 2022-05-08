package com.codegym.democms.service.Impl;

import com.codegym.democms.model.Message;
import com.codegym.democms.repository.MessageRepository;
import com.codegym.democms.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class MessageServiceImpl implements IMessageService {
    @Autowired
    MessageRepository messageRepository;

    @Override
    public Iterable<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Optional<Message> findById(Integer id) {
        return messageRepository.findById(id);
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void remove(Integer id) {
        messageRepository.deleteById(id);
    }
}
