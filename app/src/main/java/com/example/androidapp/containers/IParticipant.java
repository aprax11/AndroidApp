package com.example.androidapp.containers;


public interface IParticipant{
    /*
    gets the score of the participant for a certain challenge
    @return String score
     */
    String getScore();
    /*
    sets the score of the participant for a certain challenge
     */
    void setScore(String score);
    /*
    gets the name of the participant for a certain challenge
    @return String name
     */
    String getName();
    /*
    sets the name of the participant for a certain challenge
     */
    void setName(String name);
}
