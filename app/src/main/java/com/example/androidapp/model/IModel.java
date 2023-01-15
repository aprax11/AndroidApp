package com.example.androidapp.model;

import com.example.androidapp.containers.IChallenge;
import com.example.androidapp.containers.IParticipant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface IModel extends Serializable {
    List<IChallenge> getAll();

    ArrayList<IParticipant> getParticipants(String id);

    String addParticipation(String participantName, String score, String challengeId);

    String addChallenge(String challengeName, String challengeDescription);

    IAsyncTaskWrapper getAsyncTaskWrapper();

    void setAsyncTaskWrapper(IAsyncTaskWrapper asyncTaskWrapper);
}
