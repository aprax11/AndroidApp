package com.example.androidapp.containers;

import java.io.Serializable;

public interface IParticipant extends Serializable {
    String getScore();

    void setScore(String score);

    String getName();

    void setName(String name);
}
