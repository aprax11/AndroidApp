package com.example.androidapp.model;

import java.io.Serializable;

public class Participant implements IParticipant {
    @Override
    public String getScore() {
        return score;
    }

    @Override
    public void setScore(String score) {
        this.score = score;
    }

    String score;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    String name;
}
