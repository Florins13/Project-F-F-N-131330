package com.ctw.ffn131330.genericTournament.payload;

import com.ctw.ffn131330.game.GameType;

import java.util.List;

public class GenericTournament {

    private List<String> listOfPlayers;

    private GameType gameType;

    public GenericTournament(){}
    public GenericTournament(List<String> playersName, GameType gameType) {
        this.listOfPlayers = playersName;
        this.gameType = gameType;
    }


    public List<String> getListOfPlayers() {
        return listOfPlayers;
    }

    public void setListOfPlayers(List<String> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }


    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }
}
