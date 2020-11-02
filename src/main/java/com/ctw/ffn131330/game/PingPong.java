package com.ctw.ffn131330.game;

import com.ctw.ffn131330.game.GameType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PingPong")
public class PingPong extends GameType {

}
