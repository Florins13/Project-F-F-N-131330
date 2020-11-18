package com.ctw.ffn131330.tournament;

import com.ctw.ffn131330.base.BaseRepository;
import com.ctw.ffn131330.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TournamentService extends BaseService <Tournament> {

    @Autowired
    TournamentRepository repository;

    @Override
    public BaseRepository<Tournament> getRepository() {
        return repository;
    }
}
