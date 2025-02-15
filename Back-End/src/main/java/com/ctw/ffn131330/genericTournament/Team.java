package com.ctw.ffn131330.genericTournament;

import java.util.List;

public class Team {
    public Team(String name){}

    public List<String> getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers(List<String> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    private List<String> teamPlayers;
}
