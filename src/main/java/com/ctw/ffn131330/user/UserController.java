package com.ctw.ffn131330.user;

import com.ctw.ffn131330.match.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping ("/")
    public String getIndex(){
        return "Welcome to Side project!";
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return userService.save(user);
    }

    @PostMapping ("/saveDefault")
    public void saveDefault(){
        userService.saveDefault();
    }

    @PostMapping("/saveUser5char")
    public User saveUser5char(@RequestBody User user) {
        return userService.check5chars(user);
    }

    @GetMapping ("/getById/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getById(id);
    }

    @GetMapping ("/getAll")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @DeleteMapping ("/deleteById/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.delete(id);
    }

    @GetMapping("/getMatches/{userId}")
    public List<Match> getMatches(@PathVariable Long userId){
        return userService.getMatchByUsrId(userId);
    }
}
