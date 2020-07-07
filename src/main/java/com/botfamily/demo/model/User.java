package com.botfamily.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password;
    private int age;

    public User() {}

    public User(String username, String password, int age){
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
