package com.example.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class ExampleTest {

    @Autowired
    private Example example;

    @Test
    public void set() {

        example.set("example-string", "hello world");
    }

    @Test
    public void add() {
        for (int i = 0; i < 10; i++) {
            example.add("example-set", "hello world");
        }

    }

    @Test
    public void addWithScore() {
        for (int i = 0; i < 10; i++) {
            example.add("example-zset", "hello world", i);
        }
    }

    @Test
    public void push() {
        for (int i = 0; i < 10; i++) {
            example.push("example-list", "hello world");
        }

    }

    @Test
    public void put() {
        Map<String, String> value = new HashMap<>();
        value.put("example-hash", "hello world");
        for (int i = 0; i < 10; i++) {
            example.put("example-hash", value);
        }
    }

    @Test
    public void expire() {

        example.expire("example-string", 10, TimeUnit.SECONDS);

        example.expire("example-set", 20, TimeUnit.SECONDS);
    }


}
