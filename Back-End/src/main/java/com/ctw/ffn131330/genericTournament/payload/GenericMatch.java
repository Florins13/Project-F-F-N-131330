package com.ctw.ffn131330.genericTournament.payload;

import com.ctw.ffn131330.base.BaseEntity;

import javax.persistence.Entity;

@Entity
public class GenericMatch extends BaseEntity {
    private int matchNumber;
    private String playerOne;
    private String playerTwo;
}
