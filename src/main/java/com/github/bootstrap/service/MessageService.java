package com.github.bootstrap.service;

import com.github.bootstrap.exception.MessageNotFoundException;
import com.github.bootstrap.exception.ValidationMessage;
import com.github.bootstrap.model.Message;
import com.github.bootstrap.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        List<Message> result = (List<Message>) messageRepository.findAll();

        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Message>();
        }
    }

    public Message getMessageById(Long id) throws MessageNotFoundException {
        Optional<Message> message = messageRepository.findById(id);

        if (message.isPresent()) {
            return message.get();
        } else {
            throw new MessageNotFoundException("No message record exist for given id");
        }
    }

    public Message createOrUpdateMessage(Message message) {
        if (message.getDescription().isEmpty()) {
            throw new ValidationMessage("Message user name and description are mandatory");
        }
        if (message.getId() == null) {
            message = messageRepository.save(message);

            return message;
        } else {
            Optional<Message> entity = messageRepository.findById(message.getId());

            if (entity.isPresent()) {
                Message newMessage = entity.get();
                newMessage.setUserName(message.getUserName());
                newMessage.setDescription(message.getDescription());
                newMessage = messageRepository.save(newMessage);

                return newMessage;
            } else {
                message = messageRepository.save(message);

                return message;
            }
        }
    }

}
