package com.ctw.ffn131330.genericTournament.payload;

import com.ctw.ffn131330.game.GameType;
import org.springframework.lang.NonNull;

import java.util.List;

public class GenericTournament {

    @NonNull
    private List<GenericPlayer> listOfPlayers;

    @NonNull
    private GameType gameType;

    public GenericTournament(){}
    public GenericTournament(@NonNull List<GenericPlayer> playersName, @NonNull GameType gameType) {
        this.listOfPlayers = playersName;
        this.gameType = gameType;
    }

    @NonNull
    public List<GenericPlayer> getListOfPlayers() {
        return listOfPlayers;
    }

    public void setListOfPlayers(@NonNull List<GenericPlayer> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }
}
