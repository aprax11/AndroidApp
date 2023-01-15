package com.example.androidapp.activitys;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.withSettings;


import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.androidapp.R;
import com.example.androidapp.model.Control;
import com.example.androidapp.model.IControl;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)


public class ChallengeActivityTest {
    @Mock
    IControl control = mock(Control.class, withSettings().serializable());
    //Connection connection = mock(Connection.class);

    @Rule
    public final ActivityScenarioRule<ChallengeActivity> scenarioRule =
            new ActivityScenarioRule<>(
                    new Intent(
                            InstrumentationRegistry.getInstrumentation().getTargetContext(),
                            ChallengeActivity.class)
                            .putExtra("ID", "1")
                            .putExtra("CONTROL", control)
            );

    @Test
    public void isActivityInView_Test() {
        ActivityScenario<ChallengeActivity> scenario = scenarioRule.getScenario();

        onView(withId(R.id.challengeActivity)).check(matches(isDisplayed()));
    }
    @Test
    public void isAddParticipationNameDisplayed_Test() {
        ActivityScenario<ChallengeActivity> scenario = scenarioRule.getScenario();

        onView(withId(R.id.addParticipationName)).check(matches(isDisplayed()));
    }
    @Test
    public void isAddParticipationScoreDisplayed_Test() {
        ActivityScenario<ChallengeActivity> scenario = scenarioRule.getScenario();

        onView(withId(R.id.addParticipationScore)).check(matches(isDisplayed()));
    }
    @Test
    public void isAddParticipationButtonDisplayed_Test() {
        ActivityScenario<ChallengeActivity> scenario = scenarioRule.getScenario();

        onView(withId(R.id.addParticipationButton)).check(matches(isDisplayed()));
    }
    @Test
    public void isAddParticipationButtonTextDisplayed_Test() {
        ActivityScenario<ChallengeActivity> scenario = scenarioRule.getScenario();

        onView(withId(R.id.addParticipationButton)).check(matches(withText("add Score")));
    }
    /*
    @Test
    public void Button_Test() {
        ActivityScenario<ChallengeActivity> scenario = scenarioRule.getScenario();


        onView(withId(R.id.addParticipationScore)).check(matches(isDisplayed()));
        onView(withId(R.id.addParticipationName)).perform(typeText("ButtonTest"));
        onView(withId(R.id.addParticipationScore)).perform(typeText("10"));


        onView(withId(R.id.addParticipationButton)).perform(click());
        verify(control).addParticipation(anyString(), anyString(), anyString(), any(Network.class));

    }

     */

    @Test
    public void isListviewDisplayed_Test() {
        ActivityScenario<ChallengeActivity> scenario = scenarioRule.getScenario();

        onView(withId(R.id.ParticipantsList)).check(matches(isDisplayed()));
    }
}
