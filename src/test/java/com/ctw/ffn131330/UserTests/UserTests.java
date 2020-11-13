package com.ctw.ffn131330.UserTests;

import com.ctw.ffn131330.user.UserController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserTests {

    @Autowired
    private UserController userController;

    private UserTestsUtils userUtils = new UserTestsUtils();

    // write test cases here
    @Test
    public void saveUser(){
        assertThat(userController).isNotNull();

    }

}