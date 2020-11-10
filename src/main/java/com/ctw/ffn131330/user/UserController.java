package com.ctw.ffn131330.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public List<User> saveUser(){
        User usr = userService.save(new User("Nuno"));
        return null; //userService.get(usr.getId());
    }

}
