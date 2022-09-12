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
    GenericTournamentRepository genericTournamentRepository;
    @Override
    public BaseRepository<GenerateTournament> getRepository() {
        return genericTournamentRepository;
    }

    public GenerateTournament createTournament(GenericTournamentDTO genericTournamentDTO) {
        Collections.shuffle(genericTournamentDTO.getListOfPlayers());
        System.out.println("Shuffled" + genericTournamentDTO.getListOfPlayers());

        GenerateTournament generateTournament = new GenerateTournament();
        generateTournament.setGameType(genericTournamentDTO.getGameType());
        generateTournament.setInitialMatches(genericTournamentDTO.getListOfPlayers().size()%2 == 0 ? genericTournamentDTO.getListOfPlayers().size()/2 : (int) Math.ceil(genericTournamentDTO.getListOfPlayers().size() / 2.0));

        // iterate genericTournamentDTO.getListOfPlayers()
        // even players --- get 0 -> 1 , 2 -> 3 , 4 -> 5 ---> 2*index - 2*index+1
        // odd players --- 7 players -> listOfPlayers.size-1(because index starts at 0) < 7 ? null : player
        // [1,2,3,4,5,6,7]
        for(int i = 0; i < generateTournament.getInitialMatches(); i++){
            String playerOne = genericTournamentDTO.getListOfPlayers().get(i*2); // this will start from 2 if we do i = 1, better to stay at 0
            String playerTwo = genericTournamentDTO.getListOfPlayers().size()-1 < i*2+1 ? null : genericTournamentDTO.getListOfPlayers().get((i*2)+1);
            generateTournament.getTournament().put(i+1, new GenericMatch(i+1, playerOne, playerTwo));
        }
        genericTournamentRepository.save(generateTournament);
        return generateTournament;
    }
}
