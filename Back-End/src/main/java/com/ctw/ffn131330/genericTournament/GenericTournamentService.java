package com.ctw.ffn131330.genericTournament;

import com.ctw.ffn131330.base.BaseRepository;
import com.ctw.ffn131330.base.BaseService;
import com.ctw.ffn131330.genericTournament.payload.CreateGenericTournamentDTO;
import com.ctw.ffn131330.genericTournament.payload.GenericTournamentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenericTournamentService extends BaseService<GenerateTournament> {

    @Autowired
    GenericTournamentRepository genericTournamentRepository;
    @Override
    public BaseRepository<GenerateTournament> getRepository() {
        return genericTournamentRepository;
    }

    public GenerateTournament createTournament(CreateGenericTournamentDTO createGenericTournamentDTO) {
        Collections.shuffle(createGenericTournamentDTO.getListOfPlayers());
        System.out.println("Shuffled" + createGenericTournamentDTO.getListOfPlayers());

        GenerateTournament generateTournament = new GenerateTournament();
        generateTournament.setGameType(createGenericTournamentDTO.getGameType());
        generateTournament.setInitialMatches(createGenericTournamentDTO.getListOfPlayers().size()%2 == 0 ? createGenericTournamentDTO.getListOfPlayers().size()/2 : (int) Math.ceil(createGenericTournamentDTO.getListOfPlayers().size() / 2.0));


        Integer phases = generateTournament.getTournamentNumberPhases();


        for(int i = phases-1; i >= 0; i--){ // we want to loop 4 phases, 0,1,2,3 not 5 times 0,1,2,3,4
            for(int j = 0; j < (Math.pow(2,i)); j++){ // ex: 2 at power of 3 = 8 which is initial number of matches
                if(phases-1 == i){ //we want only the first phase/loop and the rest is TBD's
                    String playerOne = createGenericTournamentDTO.getListOfPlayers().get(j*2); // this will start from 2 if we do i = 1, better to stay at 0
                    String playerTwo = createGenericTournamentDTO.getListOfPlayers().size()-1 < j*2+1 ? null : createGenericTournamentDTO.getListOfPlayers().get((j*2)+1);
                    generateTournament.getMatches().add(new GenericMatch(j+1, playerOne, playerTwo, null, null));
                }
                else {
                    generateTournament.getMatches().add( new GenericMatch(j+1, null, null, null, null, false));
                }
            }
        }

        genericTournamentRepository.save(generateTournament);
        return generateTournament;
    }

    public List<GenericTournamentDTO> getAllGenericTournaments(){
        return this.genericTournamentRepository.findAll().stream().map(item-> new GenericTournamentDTO(item)).collect(Collectors.toList());
    };

    @Transactional
    public GenericTournamentDTO updateTournament(GenericTournamentDTO tournament){
        // find game 1 -> has 2 sc0res -> persist to db.
        // phases of tournament -> persist when all the games are complete.
        // dto -> genericTournament -> persist
        // dto -> find the game-> check -> getid -> persist to db

        GenerateTournament tournamentEntity = this.getRepository().findById(tournament.getId()).get();
        tournamentEntity.setGameType(tournament.getGameType());
        tournamentEntity.setMatches(tournament.getMatchesAsList());
        tournamentEntity.setInitialMatches(tournament.getInitialMatches());
        GenerateTournament persistedTournament = this.genericTournamentRepository.save(tournamentEntity);
        return new GenericTournamentDTO(persistedTournament);
    };


}
