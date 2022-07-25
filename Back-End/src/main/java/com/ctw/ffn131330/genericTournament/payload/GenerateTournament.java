package com.ctw.ffn131330.genericTournament.payload;

import com.ctw.ffn131330.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class GenerateTournament extends BaseEntity {
    private Integer initialMatches;

    @OneToMany
    private List<GenericMatch> matches;



}


// --> 4  ----------- A vs B, C vs D,         Z vs F, R vs S
//     2  ----------- A vs C                  Z vs R



// Player [ {A vs B}, {C vs D}, {Z vs F}, {R vs S}]

// A vs D, F vs R
