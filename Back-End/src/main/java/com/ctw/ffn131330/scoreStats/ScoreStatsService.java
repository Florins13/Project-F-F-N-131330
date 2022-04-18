package com.ctw.ffn131330.scoreStats;

import com.ctw.ffn131330.base.BaseRepository;
import com.ctw.ffn131330.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreStatsService extends BaseService<ScoreStats> {

    @Autowired
    ScoreStatsRepository repository;

    @Override
    public BaseRepository<ScoreStats> getRepository() {
        return null;
    }
}
