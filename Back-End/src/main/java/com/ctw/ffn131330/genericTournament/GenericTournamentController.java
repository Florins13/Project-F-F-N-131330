package com.ctw.ffn131330.genericTournament;

import com.ctw.ffn131330.genericTournament.payload.GenerateTournament;
import com.ctw.ffn131330.genericTournament.payload.CreateGenericTournamentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/genericTournament")
public class GenericTournamentController {

    @Autowired
    GenericTournamentService genericTournamentService;


    @PostMapping("/createSinglePlayers")
    public GenerateTournament createMatch(@RequestBody CreateGenericTournamentDTO createGenericTournamentDTO) {
        return genericTournamentService.createTournament(createGenericTournamentDTO);
    }

    @GetMapping("/getAllTournaments")
    public List<GenerateTournament> getTournaments() {

        //List<GenerateTournament> list = new ArrayList<>();

        //GenericTournamentDTO dto = new GenericTournamentDTO(Arrays.asList("nuno", "Florin", "player3", "player4", "player5", "3","7","8"), GameType.PING_PONG);

        //list.add(genericTournamentService.createTournament(dto));

        //return list;
        return genericTournamentService.getAll();
    }

    @GetMapping("/cenas")
    public List<List<Integer>> getCenas(){
        List<List<Integer>> test = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        List<Integer> third = new ArrayList<>();
        List<Integer> forth = new ArrayList<>();
        first.add(1);
        first.add(2);
        first.add(2);
        first.add(2);
        second.add(3);
        second.add(4);
        second.add(4);
        second.add(4);
        third.add(4);
        third.add(4);
        third.add(4);
        third.add(4);
        forth.add(4);
        forth.add(4);
        forth.add(4);
        forth.add(4);
        test.add(first);
        test.add(second);
        test.add(third);
        test.add(forth);
//    [[3,3,3], [1,2,3] [4,5,6]]
        return test;
    }
}
