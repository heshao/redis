package com.example.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessagingTest {

    @Autowired
    private Messaging messaging;

    @Test
    public void send() {
        messaging.send();
    }
}
