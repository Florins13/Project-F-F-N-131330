package com.ctw.ffn131330;

import com.ctw.ffn131330.game.PingPong;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ffn131330Application {
    public static void main(String[] args) {
        SpringApplication.run(Ffn131330Application.class, args);
        PingPong pingPong = new PingPong();
        pingPong.setScore(1);
        pingPong.setName("Test name of pingpong");
    }
}
