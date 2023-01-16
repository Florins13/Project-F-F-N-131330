package com.ctw.ffn131330.genericTournament.payload;

import com.ctw.ffn131330.game.GameType;
import com.ctw.ffn131330.genericTournament.GenerateTournament;
import com.ctw.ffn131330.genericTournament.GenericMatch;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GenericTournamentDTO {
    private Integer initialMatches;
    private Integer totalMatches;

    private Long id;

    private List<List<GenericMatch>> matches = new LinkedList<>();

    public GenericTournamentDTO(){}
    public GenericTournamentDTO(GenerateTournament generateTournament){
        this.id = generateTournament.getId();
        this.initialMatches = generateTournament.getInitialMatches();
        this.totalMatches = generateTournament.getMatches().size();
        this.matches = createLayers(generateTournament);
        this.gameType = generateTournament.getGameType();
    }

    @Enumerated(EnumType.STRING)
    GameType gameType;


    public List<List<GenericMatch>> createLayers(GenerateTournament tournament){
        Integer phases = tournament.getTournamentNumberPhases();
//
//        [ [1,2,3,4], [3,4], [1]  ]
//        Integer initialPosition = ;
//        Integer lastPosition = this.initialMatches-1;

        // 0-1
        // 2

        // 0--3
        // 4-6
        // 7

        // 0-7
        // 8-11
        // 12-13
        // 14

        Integer counter = 0;
        Integer fromIndex = 0;
        Integer toIndex = tournament.getInitialMatches()-1; // 7 -- 11


        //this.matches.add(tournament.getMatches().subList(0, tournament.getInitialMatches()-1));
        while(counter < phases - 1){
            this.matches.add(tournament.getMatches().subList(fromIndex, toIndex+1));
            counter++;
            fromIndex = toIndex + 1; //8 -- 12
            toIndex = toIndex + (tournament.getInitialMatches()/(2 * counter)); // 11 -- 11 + ((11/2)/2)
        }
        //this.matches.add(tournament.getMatches().subList(tournament.getMatches().size()-1, tournament.getMatches().size()-1));
        this.matches.add(Arrays.asList(tournament.getMatches().get(tournament.getMatches().size()-1)));

        return matches;
    }
    public Integer getInitialMatches() {
        return initialMatches;
    }

    public void setInitialMatches(Integer initialMatches) {
        this.initialMatches = initialMatches;
    }

    public List<List<GenericMatch>> getMatches() {
        return matches;
    }

    public void setMatches(List<List<GenericMatch>> tournament) {
        this.matches = tournament;
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
}
