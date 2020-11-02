package com.ctw.ffn131330.match;

import com.ctw.ffn131330.game.GameType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigInteger;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private BigInteger id;

    @ManyToOne
    private GameType gameType;

//    @ManyToMany
//    private List<User> teamOne;
//
//    @ManyToMany
//    private List<User> teamTwo;
    

    public BigInteger getId() {
        return id;
    }


}
