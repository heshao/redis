package com.example.entity;

import com.example.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            Person person = personService.get(i);
            System.out.println(person.toString());
        }
    }
}
