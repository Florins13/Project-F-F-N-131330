package com.ctw.ffn131330.scoreStats;

import com.ctw.ffn131330.base.BaseEntity;
import com.ctw.ffn131330.match.Match;
import com.ctw.ffn131330.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ScoreStats extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="match_id")
    @JsonIgnore
    private Match match;

    public ScoreStats(){

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
//    @Column
//    private int score;
}
