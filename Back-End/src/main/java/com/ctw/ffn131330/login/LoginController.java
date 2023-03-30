package com.ctw.ffn131330.login;

import com.ctw.ffn131330.security.jwt.JwtTokenUtil;
import com.ctw.ffn131330.user.User;
import com.ctw.ffn131330.user.UserService;
import com.ctw.ffn131330.utils.UserAuthDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    UserService userService;



    @PostMapping("")
    public UserAuthDetails getUser(@RequestBody @Valid Login login) throws Exception {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        final User user = userService.getUserByUserName(login.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return loginService.getUserFromLogin(login, token);
    }

//    @GetMapping("/test")
//    public String login(Principal principal) throws Exception {
//        System.out.println(principal);
//        return principal.getName();
//    }
//
//    @GetMapping("/test2")
//    public Object getContextUser(@RequestBody Login login){
//        final Object contextUser = SecurityContextHolder.getContext().getAuthentication();
//        return contextUser;
//    }
}
