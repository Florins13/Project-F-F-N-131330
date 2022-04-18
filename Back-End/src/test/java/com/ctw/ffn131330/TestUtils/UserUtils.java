package com.ctw.ffn131330.TestUtils;

import com.ctw.ffn131330.user.User;

public class UserUtils {

    public String json = "{\n" +
            "\"name\": \"alaska\"\n" +
            "}";

    public User mockUser(){
        User userOne = new User();
        userOne.setId(1L);
        userOne.setName("userone");
        return userOne;
    }
}
