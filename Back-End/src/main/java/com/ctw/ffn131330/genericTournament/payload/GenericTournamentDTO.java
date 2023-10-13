package com.ctw.ffn131330.genericTournament.payload;

import com.ctw.ffn131330.game.GameType;
import com.ctw.ffn131330.genericTournament.GenerateTournament;
import com.ctw.ffn131330.genericTournament.GenericMatch;
import com.ctw.ffn131330.genericTournament.Phase;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;
import java.util.stream.Collectors;

public class GenericTournamentDTO {
    private Integer initialMatches;
    private Integer totalMatches;

    private Long id;

    private List<Phase> phases;


    @Enumerated(EnumType.STRING)
    GameType gameType;

    public GenericTournamentDTO(){}
    public GenericTournamentDTO(GenerateTournament generateTournament){
        this.id = generateTournament.getId();
        this.initialMatches = generateTournament.getInitialMatches();
        this.totalMatches = generateTournament.getPhases().size();
        this.phases = generateTournament.getPhases();
        this.gameType = generateTournament.getGameType();
    }

    public List<GenericMatch> getMatchesAsList() {
        return this.phases.stream().flatMap(phase -> phase.getMatches().stream()).collect(Collectors.toList());
    };
    public Integer getInitialMatches() {
        return initialMatches;
    }

    public void setInitialMatches(Integer initialMatches) {
        this.initialMatches = initialMatches;
    }


    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public List<Phase> getPhases() {
        return phases;
    }

    public void setPhases(List<Phase> phases) {
        this.phases = phases;
    }
}
