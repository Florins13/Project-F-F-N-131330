package com.ctw.ffn131330.utils;

import com.ctw.ffn131330.game.PingPong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

public class TestRunner {

    @Autowired
    private static UserService em;

    public static void main(String[] args) {
        SpringApplication.run(com.ctw.ffn131330.Ffn131330Application.class, args);
        PingPong pingPong = new PingPong();
        pingPong.setScore(1);
        pingPong.setName("Test name of pingpong");
        em.insert(pingPong);

    }
}
