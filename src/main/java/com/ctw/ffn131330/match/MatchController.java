package com.ctw.ffn131330.match;

import com.ctw.ffn131330.game.GameType;
import com.ctw.ffn131330.match.payload.CreateMatchPayload;
import com.ctw.ffn131330.user.UserService;
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
@RequestMapping("/match")
public class MatchController {

    @Autowired
    MatchService matchService;

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public Match createMatch(@RequestBody CreateMatchPayload newMatch) {
        userService.saveDefault();
        return matchService.createMatch(newMatch);
    }
    @GetMapping("/getById/{id}")
    public Match getMatchById(@PathVariable long id) {
        return matchService.getById(id);
    }

    @GetMapping("/getAll")
    public List<Match> getAll(){
        return matchService.getAll();
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable long id){
        matchService.delete(id);
    }
}
