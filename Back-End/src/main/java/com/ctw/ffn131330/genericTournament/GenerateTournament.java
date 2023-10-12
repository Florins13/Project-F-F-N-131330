package com.ctw.ffn131330.genericTournament;

import com.ctw.ffn131330.base.BaseEntity;
import com.ctw.ffn131330.game.GameType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class GenerateTournament extends BaseEntity {
    private Integer initialMatches;

    @JoinTable(name = "tournament_map_matches",
            joinColumns = {@JoinColumn(name = "generic_tournament_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "generic_match_id", referencedColumnName = "id")})
    @OneToMany(cascade = CascadeType.ALL)
    private List<GenericMatch> matches = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    GameType gameType;

    public GenerateTournament() {
    }

    public GenerateTournament(List<GenericMatch> matches, GameType gameType) {
        this.matches = matches;
        this.gameType = gameType;
    }

    public Integer getInitialMatches() {
        return initialMatches;
    }

    //TODO: this works only for happy cases, to do in future for other cases like 10 players
    public Integer getTournamentNumberPhases(){
        return (int) (Math.log(this.initialMatches*2)/Math.log(2));
    }

    public void setInitialMatches(Integer initialMatches) {
        this.initialMatches = initialMatches;
    }

    public List<GenericMatch> getMatches() {
        return matches;
    }

    public void setMatches(List<GenericMatch> tournament) {
        this.matches = tournament;
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
