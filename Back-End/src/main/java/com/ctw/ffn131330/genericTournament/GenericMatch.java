package com.ctw.ffn131330.genericTournament;

import com.ctw.ffn131330.base.BaseEntity;

import javax.persistence.Entity;

@Entity
public class GenericMatch extends BaseEntity {
    private int matchNumber;
    private String playerOne;
    private String playerTwo;

    public GenericMatch() {
    }

    public GenericMatch(int matchNumber, String playerOne, String playerTwo) {
        this.matchNumber = matchNumber;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public String getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(String playerOne) {
        this.playerOne = playerOne;
    }



    public String getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(String playerTwo) {
        this.playerTwo = playerTwo;
    }


}
