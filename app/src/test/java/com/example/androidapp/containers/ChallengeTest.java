package com.example.androidapp.containers;

import org.junit.Assert;
import org.junit.Test;

public class ChallengeTest {

    @Test
    public void getSetNameTest(){
        IChallenge challenge = new Challenge();
        challenge.setName("challenge");

        Assert.assertEquals("challenge", challenge.getName());
    }
    @Test
    public void getSetDescriptionTest(){
        IChallenge challenge = new Challenge();
        challenge.setDescription("description");

        Assert.assertEquals("description", challenge.getDescription());
    }
    @Test
    public void getSetIdTest(){
        IChallenge challenge = new Challenge();
        challenge.setId("id");

        Assert.assertEquals("id", challenge.getId());
    }
}
