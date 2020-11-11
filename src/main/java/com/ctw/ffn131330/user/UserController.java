package com.ctw.ffn131330.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping ("/getUserById/{id}")
    public User getUserById(@PathVariable BigInteger id){
        return userService.get(id);
    }

    @GetMapping ("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @DeleteMapping ("/deleteUserById/{id}")
    public void deleteUserById(@PathVariable BigInteger id){
        userService.delete(id);
    }

}
