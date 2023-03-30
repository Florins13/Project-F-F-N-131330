package com.ctw.ffn131330.login;

import com.ctw.ffn131330.user.UserService;
import com.ctw.ffn131330.utils.UserAuthDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserService userService;

    public UserAuthDetails getUserFromLogin(Login login, String token) throws Exception {
          return userService.getAuthenticatedUser(login,token);
    }
}
