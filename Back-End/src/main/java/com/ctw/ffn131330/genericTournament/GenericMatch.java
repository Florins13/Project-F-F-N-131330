package com.ctw.ffn131330.genericTournament;

import com.ctw.ffn131330.base.BaseEntity;

import javax.persistence.Entity;

@Entity
public class GenericMatch extends BaseEntity {
    private int matchNumber;
    private String playerOne;
    private String playerTwo;

    private Integer resultOne;
    private Integer resultTwo;

    private boolean complete = false;

    public GenericMatch() {
    }

    public Integer getResultOne() {
        return resultOne;
    }

    public void setResultOne(Integer resultOne) {
        this.resultOne = resultOne;
    }

    public Integer getResultTwo() {
        return resultTwo;
    }

    public void setResultTwo(Integer resultTwo) {
        this.resultTwo = resultTwo;
    }



    public GenericMatch(int matchNumber, String playerOne, String playerTwo, Integer resultOne, Integer resultTwo) {
        this.matchNumber = matchNumber;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.resultOne = resultOne;
        this.resultTwo = resultTwo;
    }

    public GenericMatch(int matchNumber, String playerOne, String playerTwo, Integer resultOne, Integer resultTwo, boolean complete){
        this(matchNumber, playerOne, playerTwo, resultOne, resultTwo);
        this.complete = complete;
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

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }


}
