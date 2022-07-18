package com.ctw.ffn131330.genericTournament;

import com.ctw.ffn131330.base.BaseRepository;
import com.ctw.ffn131330.base.BaseService;
import com.ctw.ffn131330.genericTournament.payload.GenerateTournament;
import com.ctw.ffn131330.genericTournament.payload.GenericTournament;
import com.ctw.ffn131330.genericTournament.payload.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class GenericTournamentService extends BaseService<GenerateTournament> {

    @Autowired
    GenericTournamentRepository repository;
    @Override
    public BaseRepository<GenerateTournament> getRepository() {
        return repository;
    }

    public GenerateTournament createObject(GenericTournament genericTournament) {
        if(genericTournament.getListOfPlayers().get(0) instanceof Team){
            Stream.of(genericTournament.getListOfPlayers())
                    .filter(c -> c instanceof Team)
                    .map(c -> (Team) c)
                    .forEach(System.out::println);

        }
        return new GenerateTournament();
    };
}
