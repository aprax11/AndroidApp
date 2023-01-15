package com.example.androidapp.containers;

import org.junit.Assert;
import org.junit.Test;

public class ParticipantTest {

    @Test
    public void getSetNameTest(){
        IParticipant participant = new Participant();

        participant.setName("participant");

        Assert.assertEquals("participant", participant.getName());
    }
    @Test
    public void getSetScoreTest(){
        IParticipant participant = new Participant();

        participant.setScore("score");

        Assert.assertEquals("score", participant.getScore());
    }
}
