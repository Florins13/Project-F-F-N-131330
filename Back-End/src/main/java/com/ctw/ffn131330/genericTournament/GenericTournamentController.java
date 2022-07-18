package com.ctw.ffn131330.genericTournament;

import com.ctw.ffn131330.genericTournament.payload.GenerateTournament;
import com.ctw.ffn131330.genericTournament.payload.GenericTournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genericTournament")
public class GenericTournamentController {

    @Autowired
    GenericTournamentService genericTournamentService;


    @PostMapping("/create")
    public GenerateTournament createMatch(@RequestBody GenericTournament genericTournament) {
        return genericTournamentService.createObject(genericTournament);
    }
}
