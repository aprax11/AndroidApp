package com.example.androidapp.activitys;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.androidapp.R;
import com.example.androidapp.control.Control;
import com.example.androidapp.model.Challenge;
import com.example.androidapp.model.IChallenge;
import com.example.androidapp.model.IParticipant;
import com.example.androidapp.model.Participant;

import org.hamcrest.core.AnyOf;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)

public class ChallengeActivityTest {


    @Mock
    Control controlMock;


    @Test
    public void activityResult_DisplaysContactsPhoneNumber() {
        // Build the result to return when the activity is launched.

        IParticipant testParticipant = new Participant();
        testParticipant.setName("testParticipant");
        testParticipant.setScore("10");
        ArrayList<IParticipant> testParticipantList = new ArrayList<>();
        testParticipantList.add(testParticipant);

        List<IChallenge> testChallengeList = new LinkedList<>();
        IChallenge testChallenge = new Challenge();
        testChallenge.setName("testChallenge");
        testChallenge.setId("1");
        testChallenge.setDescription("testDescription");

        testChallengeList.add(testChallenge);


/*
        try (MockedStatic<Control> utilities = Mockito.mockStatic(Control.class)) {
            utilities.when(Control::getNewInsatnce)
                    .thenReturn(controlMock);


        }

 */
        when(controlMock.getAll()).thenReturn(testChallengeList);
        when(controlMock.getParticipants("1")).thenReturn(testParticipantList);


        ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class);
        onData(allOf(instanceOf(Challenge.class))).atPosition(0).perform(click());
        onView(withId(R.id.challengeActivity)).check(matches(isDisplayed()));
    }
}
