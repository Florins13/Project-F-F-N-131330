package com.ctw.ffn131330.genericTournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genericTournament")
public class GenericTournamentController {

    @Autowired
    GenericTournamentService genericTournamentService;
}
