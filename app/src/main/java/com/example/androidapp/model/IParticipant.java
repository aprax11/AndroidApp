package com.example.androidapp.model;

import java.io.Serializable;

public interface IParticipant extends Serializable {
    String getScore();

    void setScore(String score);

    String getName();

    void setName(String name);
}
