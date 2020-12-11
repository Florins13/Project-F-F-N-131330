package com.ctw.ffn131330.match;

import com.ctw.ffn131330.game.GameType;
import com.ctw.ffn131330.match.payload.CreateMatchPayload;
import com.ctw.ffn131330.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    MatchService matchService;

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public Match saveMatch(){
        return matchService.save(new Match(GameType.PING_PONG));
    }

    @PostMapping("/create")
    public Match createMatch(@RequestBody CreateMatchPayload newMatch) {
        return matchService.createMatch(newMatch);
    }
}
