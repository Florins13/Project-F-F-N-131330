package com.ctw.ffn131330.genericTournament.payload;

import com.ctw.ffn131330.game.GameType;
import com.ctw.ffn131330.genericTournament.GenerateTournament;
import com.ctw.ffn131330.genericTournament.GenericMatch;
import com.ctw.ffn131330.genericTournament.PhaseStatusEnum;
import com.ctw.ffn131330.genericTournament.PhasesDTO;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GenericTournamentDTO {
    private Integer initialMatches;
    private Integer totalMatches;

    private Long id;

    private List<PhasesDTO> phasesDTO = new LinkedList<>();


    @Enumerated(EnumType.STRING)
    GameType gameType;

    public GenericTournamentDTO(){}
    public GenericTournamentDTO(GenerateTournament generateTournament){
        this.id = generateTournament.getId();
        this.initialMatches = generateTournament.getInitialMatches();
        this.totalMatches = generateTournament.getMatches().size();
        this.phasesDTO = createLayers(generateTournament);
        this.gameType = generateTournament.getGameType();
    }

    public List<PhasesDTO> createLayers(GenerateTournament tournament){
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
            PhasesDTO phasesDTO = new PhasesDTO();
            phasesDTO.setMatches(tournament.getMatches().subList(fromIndex, toIndex+1));
            phasesDTO.setStatus(counter == 0 ? PhaseStatusEnum.IN_PROGRESS : PhaseStatusEnum.WAITING);
            this.phasesDTO.add(phasesDTO);
            counter++;
            fromIndex = toIndex + 1; //8 -- 12
            toIndex = toIndex + (tournament.getInitialMatches()/(2 * counter)); // 11 -- 11 + ((11/2)/2)
        }
        //this.matches.add(tournament.getMatches().subList(tournament.getMatches().size()-1, tournament.getMatches().size()-1));
        PhasesDTO phasesDTO = new PhasesDTO();
        phasesDTO.setMatches(Collections.singletonList(tournament.getMatches().get(tournament.getMatches().size() - 1)));
        phasesDTO.setStatus(PhaseStatusEnum.WAITING);
        this.phasesDTO.add(phasesDTO);

        return this.phasesDTO;
    }

    public List<GenericMatch> getMatchesAsList() {
        return this.phasesDTO.stream().flatMap(phase -> phase.getMatches().stream()).collect(Collectors.toList());
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

    public List<PhasesDTO> getPhasesDTO() {
        return phasesDTO;
    }

    public void setPhasesDTO(List<PhasesDTO> phasesDTO) {
        this.phasesDTO = phasesDTO;
    }
}
