package com.ctw.ffn131330.genericTournament;

import com.ctw.ffn131330.game.GameType;
import com.ctw.ffn131330.genericTournament.payload.GenerateTournament;
import com.ctw.ffn131330.genericTournament.payload.GenericTournamentDTO;
import com.ctw.ffn131330.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/genericTournament")
public class GenericTournamentController {

    @Autowired
    GenericTournamentService genericTournamentService;


    @PostMapping("/createSinglePlayers")
    public GenerateTournament createMatch(@RequestBody GenericTournamentDTO genericTournamentDTO) {
        return genericTournamentService.createTournament(genericTournamentDTO);
    }

    @GetMapping("/getAllTournaments")
    public List<GenerateTournament> getTournaments() {

        //List<GenerateTournament> list = new ArrayList<>();

        //GenericTournamentDTO dto = new GenericTournamentDTO(Arrays.asList("nuno", "Florin", "player3", "player4", "player5", "3","7","8"), GameType.PING_PONG);

        //list.add(genericTournamentService.createTournament(dto));

        //return list;
        return genericTournamentService.getAll();
    }
}
