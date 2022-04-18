package com.ctw.ffn131330.game;

import java.util.EnumSet;

public enum GameType {

    POOL("bilhar") {
        @Override
        public Boolean rules(Integer n){
            return Pool.rules(n);
        }
    },

    PING_PONG("Tenis de mesa"){
        @Override
        public Boolean rules(Integer n){
            return n < 0;
        }
    },

    DARTS("setas"){
        @Override
        public Boolean rules(Integer n){
            return n < 0;
        }

    };

    private String name;

    GameType(String name) {
        this.name = name;
    }

    public abstract Boolean rules(Integer n);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static EnumSet<GameType> BallGames = EnumSet.of(POOL, PING_PONG);

    public static EnumSet<GameType> NoBallGames = EnumSet.of(DARTS);


}
