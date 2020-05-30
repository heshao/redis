package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author heshao
 */
@Data
public class Person implements Serializable {

    private int id;
    private String name;
    private String sex;

}
