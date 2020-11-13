package com.ctw.ffn131330.UserTests;

import com.ctw.ffn131330.user.User;

public class UserTestsUtils {

    public User mockUser(){

        User usr = new User();
        usr.setId((long) 1);
        usr.setName("Florin");
        return usr;
    }
}
