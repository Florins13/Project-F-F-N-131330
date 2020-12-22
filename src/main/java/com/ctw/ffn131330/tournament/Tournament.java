package com.ctw.ffn131330.tournament;

import com.ctw.ffn131330.base.BaseEntity;
import com.ctw.ffn131330.game.GameType;
import com.ctw.ffn131330.match.MatchStatus;
import com.ctw.ffn131330.user.User;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Tournament extends BaseEntity {

    private String tournamentName;

    @ManyToMany
    @JoinTable(
            name = "tournament_user",
            joinColumns = @JoinColumn(name = "tournement_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> players;

    @Enumerated(EnumType.STRING)
    private MatchStatus tournamentStatus;

    @Enumerated(EnumType.STRING)
    private GameType tournamentType;

    private Integer numberWinnerTeam;




    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public Set<User> getPlayers() {
        return players;
    }

    public void setPlayers(Set<User> players) {
        this.players = players;
    }

    public MatchStatus getTournamentStatus() {
        return tournamentStatus;
    }

    public void setTournamentStatus(MatchStatus tournamentStatus) {
        this.tournamentStatus = tournamentStatus;
    }

    public GameType getTournamentType() {
        return tournamentType;
    }

    public void setTournamentType(GameType tournamentType) {
        this.tournamentType = tournamentType;
    }

    public Integer getNumberWinnerTeam() {
        return numberWinnerTeam;
    }

    public void setNumberWinnerTeam(Integer numberWinnerTeam) {
        this.numberWinnerTeam = numberWinnerTeam;
    }
}
