package com.ctw.ffn131330.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.math.BigInteger;
import java.util.List;
import com.ctw.ffn131330.entity.User;
import com.ctw.ffn131330.entity.GameType;

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
