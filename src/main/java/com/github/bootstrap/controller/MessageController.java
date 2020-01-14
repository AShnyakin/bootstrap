package com.github.bootstrap.controller;

import com.github.bootstrap.model.Message;
import com.github.bootstrap.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping
    public String getAllMessageReviews(Model model) {
        List<Message> list = messageService.getAllMessages();
        model.addAttribute("message", new Message());
        model.addAttribute("messages", list);
        return "home";
    }

    @RequestMapping(path = "/createMessage", method = RequestMethod.POST)
    public String createOrUpdateMessage(Message message) {
        messageService.createUpdateMessage(message);
        return "redirect:/";
    }

}
