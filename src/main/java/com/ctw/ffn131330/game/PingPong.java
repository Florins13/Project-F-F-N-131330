package com.ctw.ffn131330.game;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PING_PONG")
public class PingPong extends GameType {

    private int score;


    public PingPong() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
