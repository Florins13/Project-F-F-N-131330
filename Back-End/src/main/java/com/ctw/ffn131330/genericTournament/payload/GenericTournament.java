package com.ctw.ffn131330.genericTournament.payload;

import org.springframework.lang.NonNull;

import java.util.List;

public class GenericTournament {

    @NonNull
    private Integer numberOfPlayers;

    @NonNull
    private List<String> playersName;
}
