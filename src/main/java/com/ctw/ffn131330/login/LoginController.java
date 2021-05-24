package com.ctw.ffn131330.login;

import com.ctw.ffn131330.user.User;
import com.ctw.ffn131330.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("")
    public User getUser(@RequestBody Login login){
        return loginService.getUserFromLogin(login);
    }
}
