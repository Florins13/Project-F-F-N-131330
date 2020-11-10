package com.ctw.ffn131330.user;

import com.ctw.ffn131330.base.BaseEntity;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {

    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
