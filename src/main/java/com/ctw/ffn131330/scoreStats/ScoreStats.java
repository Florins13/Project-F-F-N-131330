package com.ctw.ffn131330.scoreStats;

import com.ctw.ffn131330.base.BaseEntity;
import com.ctw.ffn131330.match.Match;
import com.ctw.ffn131330.user.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ScoreStats extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="match_id")
    private Match match;

//    @Column
//    private int score;
}
