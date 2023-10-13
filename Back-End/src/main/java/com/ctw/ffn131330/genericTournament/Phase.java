package com.ctw.ffn131330.genericTournament;

import com.ctw.ffn131330.base.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Phase extends BaseEntity {

    @JoinTable(name = "phase_map_matches",
            joinColumns = {@JoinColumn(name = "phase_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "generic_match_id", referencedColumnName = "id")})
    @OneToMany(cascade = CascadeType.ALL)
    private List<GenericMatch> matches = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private PhaseStatusEnum status;

    public Phase(){}

    public Phase(List<GenericMatch> matches, PhaseStatusEnum status) {
        this.matches = matches;
        this.status = status;
    }

    public List<GenericMatch> getMatches() {
        return matches;
    }

    public void setMatches(List<GenericMatch> matches) {
        this.matches = matches;
    }

    public PhaseStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PhaseStatusEnum status) {
        this.status = status;
    }

}
