package com.ctw.ffn131330.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public User saveUser(){
        return userService.save(new User("Nuno"));
    }

    @PostMapping("/getUserById")
    public User getUserById(BigInteger id){
        return userService.get(id);
    }

    @PostMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping("/deleteUserById")
    public void deleteUserById(BigInteger id){
        userService.delete(id);
    }

}
