package com.ctw.ffn131330.user;

import com.ctw.ffn131330.base.BaseEntity;
import com.ctw.ffn131330.scoreStats.ScoreStats;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "user")
    private List<ScoreStats> scoresStats;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
