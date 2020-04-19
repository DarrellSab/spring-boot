package com.example.demo.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class User {
    @javax.persistence.Id
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "birthday")
    private String birthday;

    public User(int id, String name, String birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }
    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
