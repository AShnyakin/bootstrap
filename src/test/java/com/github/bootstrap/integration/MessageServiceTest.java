package com.github.bootstrap.integration;

import com.github.bootstrap.model.Message;
import com.github.bootstrap.service.MessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest()
public class MessageServiceTest {

    @Autowired
    MessageService messageService;

    @Test
    public void testAddEmployeeSuccess() {
        List<Message> actualMessages = messageService.getAllMessages();
        List<Message> expectedMessages = Arrays.asList(
                new Message(1L, "Valeriy", "Nice music fine"),
                new Message(2L, "Konstantin", "Like a bus")
        );
        Assertions.assertEquals(actualMessages, expectedMessages, "Should found proper messages");
    }

}
