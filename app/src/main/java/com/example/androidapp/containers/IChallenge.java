package com.example.androidapp.containers;

public interface IChallenge {
    /*
    gets the name of the challenge that is represented by this object
    @return String name
     */
    String getName();
    /*
    sets the name of the challenge that is represented by this object
    */
    void setName(String name);
    /*
    gets the description of the challenge that is represented by this object
    @return String description
     */
    String getDescription();
    /*
    sets the description of the challenge that is represented by this object
     */
    void setDescription(String description);
    /*
    gets the id of the challenge that is represented by this object
    @return int name
     */
    String getId();
    /*
    gets the id of the challenge that is represented by this object
    this is mainly used for testing
     */
    void setId(String id);
}
