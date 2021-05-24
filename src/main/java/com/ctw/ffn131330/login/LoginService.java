package com.ctw.ffn131330.login;

import com.ctw.ffn131330.user.User;
import com.ctw.ffn131330.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserService userService;

    public User getUserFromLogin(Login login){
        return userService.getUserByUserName(login.getUsername());
    }
}
