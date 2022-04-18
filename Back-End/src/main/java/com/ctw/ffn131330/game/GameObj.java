package com.ctw.ffn131330.game;

public abstract class GameObj {

    private String name;

    protected GameType gameType;


    public GameObj() {
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
