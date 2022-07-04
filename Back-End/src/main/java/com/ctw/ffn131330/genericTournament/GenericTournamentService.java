package com.ctw.ffn131330.genericTournament;

import com.ctw.ffn131330.base.BaseRepository;
import com.ctw.ffn131330.base.BaseService;
import com.ctw.ffn131330.genericTournament.payload.GenerateTournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenericTournamentService extends BaseService<GenerateTournament> {

    @Autowired
    GenericTournamentRepository repository;
    @Override
    public BaseRepository<GenerateTournament> getRepository() {
        return repository;
    }
}
