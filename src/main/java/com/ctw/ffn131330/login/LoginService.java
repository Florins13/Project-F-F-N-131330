package com.ctw.ffn131330.login;

import com.ctw.ffn131330.user.User;
import com.ctw.ffn131330.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class LoginService {
    @Autowired
    UserService userService;

    public User getUserFromLogin(Login login) throws Exception {
          return userService.checkPassword(login);
    }
}
