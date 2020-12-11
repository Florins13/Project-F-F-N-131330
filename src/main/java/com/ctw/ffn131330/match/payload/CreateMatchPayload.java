package com.ctw.ffn131330.match.payload;

import com.ctw.ffn131330.user.User;
import org.springframework.lang.NonNull;

import java.util.List;

public class CreateMatchPayload {

    @NonNull
    private List<User> teamOne;

    @NonNull
    private List<User> teamTwo;

    private String matchStatus;
    private String gameType;

    private long scheduledDate;

    public CreateMatchPayload(){
    }

    public List<User> getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(List<User> teamOne) {
        this.teamOne = teamOne;
    }

    public List<User> getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(List<User> teamTwo) {
        this.teamTwo = teamTwo;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    public long getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(long scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }
}
