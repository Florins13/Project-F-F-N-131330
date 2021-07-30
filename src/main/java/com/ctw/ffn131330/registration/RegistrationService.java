package com.ctw.ffn131330.registration;

import com.ctw.ffn131330.exceptions.GenericException;
import com.ctw.ffn131330.user.User;
import com.ctw.ffn131330.user.UserRole;
import com.ctw.ffn131330.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.TransactionalException;

@Service
public class RegistrationService {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailValidator emailValidator;

    public String register(RegistrationRequest req) throws Exception {
        boolean isValidEmail = emailValidator.test(req.getEmail());
        if(!isValidEmail) throw new IllegalStateException(req.getEmail() + " is not an valid email!");
        try{
            userService.singUpUser(
                    new User(req.getName(),
                            req.getUserName(),
                            req.getPassword(),
                            req.getEmail(),
                            UserRole.USER));
        }
        catch (Exception e){
            throw new Exception("The registration failed.");
        }

        // TODO: add email confirmation (with token) if we want;
        return "User registered";
    }
}
