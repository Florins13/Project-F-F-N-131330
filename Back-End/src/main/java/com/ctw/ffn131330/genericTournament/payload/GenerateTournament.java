package com.ctw.ffn131330.genericTournament.payload;

import com.ctw.ffn131330.base.BaseEntity;
import com.ctw.ffn131330.game.GameType;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Map;
import java.util.TreeMap;

@Entity
public class GenerateTournament extends BaseEntity {
    private Integer initialMatches;

    @OneToMany
    private Map<Integer, GenericMatch> tournament = new TreeMap<>();

    GameType gameType;

    public GenerateTournament() {
    }

    public GenerateTournament(Integer initialMatches, TreeMap<Integer, GenericMatch> tournament, GameType gameType) {
        this.initialMatches = initialMatches;
        this.tournament = tournament;
        this.gameType = gameType;
    }

    public Integer getInitialMatches() {
        return initialMatches;
    }

    public void setInitialMatches(Integer initialMatches) {
        this.initialMatches = initialMatches;
    }

    public Map<Integer, GenericMatch> getTournament() {
        return tournament;
    }

    public void setTournament(Map<Integer, GenericMatch> tournament) {
        this.tournament = tournament;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }
}


// --> 4  ----------- A vs B, C vs D,         Z vs F, R vs S
//     2  ----------- A vs C                  Z vs R



// Player [ {A vs B}, {C vs D}, {Z vs F}, {R vs S}]

// A vs D, F vs R
