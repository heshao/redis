package com.example.service;

import com.example.entity.Person;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Cacheable(value = "person", key = "'person:'+#id")
    public Person get(int id) {

        Person person = new Person();
        person.setId(id);
        person.setName("person" + id);
        person.setSex(id % 2 == 0 ? "男" : "女");
        System.out.println("-------");
        return person;
    }

    @CachePut(key = "'person:'+#id")
    public void save(Person person) {

    }

    @CacheEvict(key = "'person:'+#id")
    public void delete(int id) {

    }
}
