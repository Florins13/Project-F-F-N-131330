package com.ctw.ffn131330.genericTournament;

import com.ctw.ffn131330.base.BaseRepository;
import com.ctw.ffn131330.base.BaseService;
import com.ctw.ffn131330.genericTournament.payload.GenerateTournament;
import com.ctw.ffn131330.genericTournament.payload.GenericMatch;
import com.ctw.ffn131330.genericTournament.payload.GenericTournamentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class GenericTournamentService extends BaseService<GenerateTournament> {

    @Autowired
    GenericTournamentRepository repository;
    @Override
    public BaseRepository<GenerateTournament> getRepository() {
        return repository;
    }

    public GenerateTournament createTournament(GenericTournamentDTO genericTournamentDTO) {
        Collections.shuffle(genericTournamentDTO.getListOfPlayers());
        System.out.println("Shuffled" + genericTournamentDTO.getListOfPlayers());



        GenerateTournament generateTournament = new GenerateTournament();
        generateTournament.setGameType(genericTournamentDTO.getGameType());
        generateTournament.setInitialMatches(genericTournamentDTO.getListOfPlayers().size()%2 == 0 ? genericTournamentDTO.getListOfPlayers().size()/2 : genericTournamentDTO.getListOfPlayers().size()+1);
        for(int i = 0; i < generateTournament.getInitialMatches()-1; i++){
            String playerOne = genericTournamentDTO.getListOfPlayers().get(i*2); // Player one
            String playerTwo = genericTournamentDTO.getListOfPlayers().size()-1 < i*2+1 ? null : genericTournamentDTO.getListOfPlayers().get(i*2+1);
            generateTournament.getTournament().put(i, new GenericMatch(i, playerOne, playerTwo));
        }
        return generateTournament;
    };
}
