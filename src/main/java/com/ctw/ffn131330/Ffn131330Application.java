package com.ctw.ffn131330;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Ffn131330Application {

    @RequestMapping("/")
    String home(){
        return "hello team";
    }
    public static void main(String[] args) {
        SpringApplication.run(Ffn131330Application.class, args);
    }

}
