package com.ctw.ffn131330.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;

public abstract class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private BigInteger id;

    private String name;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {

        this.id = id;
    }
}
