package com.ctw.ffn131330.genericTournament.payload;

import com.ctw.ffn131330.game.GameType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenericTournamentDTO {
    private Integer initialMatches;
    private Integer totalMatches;

    private Long id;

    private List<List<GenericMatch>> matches = new LinkedList<>();

    public GenericTournamentDTO(){}
    public GenericTournamentDTO(GenerateTournament generateTournament){
        this.initialMatches = generateTournament.getInitialMatches();
        this.totalMatches = generateTournament.getMatches().size();
        this.matches = matches;
        this.gameType = generateTournament.getGameType();
    }

    @Enumerated(EnumType.STRING)
    GameType gameType;


    public void createLayers(GenerateTournament tournament){
        List<List<GenericMatch>> test = new ArrayList<>();

        Integer phases = tournament.getTournamentNumberPhases();

//
//        [ [1,2,3,4], [3,4], [1]  ]
//        Integer initialPosition = ;
//        Integer lastPosition = this.initialMatches-1;

        // 0--3
        // 4-6
        // 7

        // 1--4
        // 5-6
        // 7
        Integer counter = 0;
        Integer toIndex = (tournament.getMatches().size()+1)/2;
        // TODO: create the [ [], [], [] ] using sublist
        while(counter < phases){
            if(counter == 0){
                this.matches.add(tournament.getMatches().subList(counter, tournament.getInitialMatches()-1));
            }
            else{
                this.matches.add(tournament.getMatches().subList(counter, tournament.getInitialMatches()));
            }

        }


//        for(int i = 0; i < this.phases; i++){
//
//            // to do
//            layer.subList(i*this.phases,this.phases);
////            this.matches
//        }
////        firstLayer.add(matches.stream().limit(4).collect(Collectors.toList()));
////        this.matches.add(firstLayer);
//        return matches;
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
