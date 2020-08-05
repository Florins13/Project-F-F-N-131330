package com.ctw.ffn131330.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PingPong")
public class PingPong extends GameType {
}
