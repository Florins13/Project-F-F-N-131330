package com.ctw.ffn131330.genericTournament.payload;

import java.util.List;

public class Team extends GenericPlayer{
    public Team(String name) {
        super(name);
    }

    public List<String> getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers(List<String> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    private List<String> teamPlayers;
}
