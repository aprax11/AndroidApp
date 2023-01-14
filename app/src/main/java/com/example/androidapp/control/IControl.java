package com.example.androidapp.control;

import com.example.androidapp.model.IChallenge;
import com.example.androidapp.model.IParticipant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface IControl extends Serializable {
    List<IChallenge> getAll(Network network);

    ArrayList<IParticipant> getParticipants(String id, Network network);

    String addParticipation(String participantName, String score, String challengeId, Network network);

    String addChallenge(String challengeName, String challengeDescription, Network network);
}
