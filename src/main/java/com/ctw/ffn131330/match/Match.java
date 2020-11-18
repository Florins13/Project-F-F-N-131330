package com.ctw.ffn131330.match;


import com.ctw.ffn131330.base.BaseEntity;
import com.ctw.ffn131330.game.GameType;
import com.ctw.ffn131330.user.User;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="match_Table")
public class Match extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private GameType gameType;

    @ManyToMany
    @JoinTable(
            name = "Matches_test",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<User> homeTeam;


    public Match(GameType gameType, List<User> homeTeam) {
        this.gameType = gameType;
        this.homeTeam = homeTeam;
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
