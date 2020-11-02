package com.ctw.ffn131330.game;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.math.BigInteger;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class GameType {

    @Id
    private BigInteger gameTypeId;

    private String name;

    public GameType() {
    }

    public BigInteger getGameTypeId() {
        return gameTypeId;
    }

    public void setGameTypeId(BigInteger gameTypeId) {
        this.gameTypeId = gameTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
