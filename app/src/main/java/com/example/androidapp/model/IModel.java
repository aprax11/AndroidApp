package com.example.androidapp.model;

import com.example.androidapp.containers.IChallenge;
import com.example.androidapp.containers.IParticipant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface IModel extends Serializable {
    /*
    returns a List of the current challenges registered in the database
    @return List<IChallenge> list
     */
    List<IChallenge> getAllChallenges();
    /*
    returns a List of the current participations registered for the selected challenge
    @return List<IParticipation> list
     */
    ArrayList<IParticipant> getParticipants(String id);
    /*
    add a participation registered for the selected challenge
    @return String res
    */
    String addParticipation(String participantName, String score, String challengeId);
    /*
   add a new challenge to the database
   @return String res
   */
    String addChallenge(String challengeName, String challengeDescription);
    /*
   gets AsyncTaskWrapper object, that receives the calls from the model
   mainly for testing purposes
   @return IAsyncTaskWrapper asyncTaskWrapper
   */
    IAsyncTaskWrapper getAsyncTaskWrapper();
    /*
   sets AsyncTaskWrapper object, that receives the calls from the model
   mainly for testing purposes
   */
    void setAsyncTaskWrapper(IAsyncTaskWrapper asyncTaskWrapper);
}
