package com.ctw.ffn131330.match;


import com.ctw.ffn131330.base.BaseEntity;
import com.ctw.ffn131330.game.GameType;
import com.ctw.ffn131330.scoreStats.ScoreStats;
import com.ctw.ffn131330.user.User;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="MATCH_TABLE")
public class Match extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private GameType gameType;

    @ManyToOne
    private User winner;

    @OneToMany(mappedBy = "match")
    private List<ScoreStats> scoresStats;


    public Match(GameType gameType) {
        this.gameType = gameType;
    }

    public Match() {

    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }
}
