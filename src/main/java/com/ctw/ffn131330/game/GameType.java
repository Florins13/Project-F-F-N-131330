package com.ctw.ffn131330.game;

import com.ctw.ffn131330.base.BaseEntity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="game_type", discriminatorType = DiscriminatorType.STRING)
public abstract class GameType extends BaseEntity {

    private String name;

    public GameType() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
