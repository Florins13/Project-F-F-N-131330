package com.ctw.ffn131330.match;


import com.ctw.ffn131330.base.BaseEntity;
import com.ctw.ffn131330.game.GameType;
import com.ctw.ffn131330.match.payload.CreateMatchPayload;
import com.ctw.ffn131330.scoreStats.ScoreStats;
import com.ctw.ffn131330.user.User;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="MATCH_TABLE")
public class Match extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private GameType gameType;

    @ManyToOne
    private User winner;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private List<ScoreStats> scoresStats = new ArrayList<>();

    private long scheduledDate;

    @Enumerated(EnumType.STRING)
    private MatchStatus matchStatus;


    public Match(GameType gameType) {
        this.gameType = gameType;
    }

    public Match() {
    }

    public Match(CreateMatchPayload newMatch){
        MatchStatus matchStatus = MatchStatus.valueOf(newMatch.getMatchStatus());
        GameType gameType = GameType.valueOf(newMatch.getGameType());
        if(matchStatus == null || gameType == null){
            throw new RuntimeException("Is null");
        }
        // add rest of validations
        this.matchStatus = matchStatus;
        this.gameType = gameType;
        this.scheduledDate = newMatch.getScheduledDate();
        newMatch.getTeamOne().stream().forEach(x -> addUser(x));
        newMatch.getTeamTwo().stream().forEach(x -> addUser(x));
    }

    private void addUser(User usr){
        ScoreStats scoreStats = new ScoreStats();
        scoreStats.setUser(usr);
        scoreStats.setMatch(this);
        this.getScoresStats().add(scoreStats);
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }

    public List<ScoreStats> getScoresStats() {
        return scoresStats;
    }

    public void setScoresStats(List<ScoreStats> scoresStats) {
        this.scoresStats = scoresStats;
    }

    public long getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(long scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public MatchStatus getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(MatchStatus matchStatus) {
        this.matchStatus = matchStatus;
    }
}
