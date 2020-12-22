package com.ctw.ffn131330.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tournament")
public class TournamentController {

    @Autowired
    TournamentService tournamentService;


    @PostMapping("/create")
    public Tournament createTournament() {
        return tournamentService.createTournament();
    }

    @GetMapping("/getById/{id}")
    public Tournament getTournamentById(@PathVariable long id) {
        return tournamentService.getById(id);
    }

    @GetMapping("/getAll")
    public List<Tournament> getAllTournaments(){
        return tournamentService.getAll();
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteTournamentById(@PathVariable long id){
        tournamentService.delete(id);
    }
}
