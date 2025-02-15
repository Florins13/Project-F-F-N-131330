package com.ctw.ffn131330.match;

import com.ctw.ffn131330.base.BaseRepository;
import com.ctw.ffn131330.base.BaseService;
import com.ctw.ffn131330.match.payload.CreateMatchPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService extends BaseService<Match> {

    @Autowired
    MatchRepository repository;

    @Override
    public BaseRepository<Match> getRepository() {
        return repository;
    }

    public Match createMatch(CreateMatchPayload newMatch) {
        Match match = new Match(newMatch);
        return repository.save(match);
    }

}
