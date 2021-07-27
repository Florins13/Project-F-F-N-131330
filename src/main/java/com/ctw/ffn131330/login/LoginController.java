package com.ctw.ffn131330.login;

import com.ctw.ffn131330.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("")
    public User getUser(@RequestBody Login login) throws Exception {
        return loginService.getUserFromLogin(login);
    }

    @GetMapping("/test")
    public String login(Principal principal) throws Exception {
        System.out.println(principal);
        return principal.getName();
    }

    @GetMapping("/test2")
    public Object getContextUser(@RequestBody Login login){
        final Object contextUser = SecurityContextHolder.getContext().getAuthentication();
        return contextUser;
    }
}
