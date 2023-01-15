package com.example.androidapp.model;

import com.example.androidapp.containers.IChallenge;
import com.example.androidapp.containers.IParticipant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface IControl extends Serializable {
    List<IChallenge> getAll(Network network);

    ArrayList<IParticipant> getParticipants(String id, Network network);

    String addParticipation(String participantName, String score, String challengeId, Network network);

    String addChallenge(String challengeName, String challengeDescription, Network network);
}
