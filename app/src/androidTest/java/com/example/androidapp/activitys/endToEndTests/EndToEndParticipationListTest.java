package com.example.androidapp.activitys.endToEndTests;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.androidapp.R;
import com.example.androidapp.activitys.ChallengeOverviewActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EndToEndParticipationListTest {
    @Rule
    public final ActivityScenarioRule<ChallengeOverviewActivity> scenarioRule =
            new ActivityScenarioRule<>(
                    new Intent(
                            InstrumentationRegistry.getInstrumentation().getTargetContext(),
                            ChallengeOverviewActivity.class)
                            .putExtra("MODE", "run")
            );

    @Test
    public void listViewDataPosOneName_Test() {
        ActivityScenario<ChallengeOverviewActivity> scenario = scenarioRule.getScenario();

        onData(allOf()).inAdapterView(withId(R.id.listview)).atPosition(1).perform(click());

        onView(withId(R.id.addParticipationName)).perform(typeText("TestName"));

        onView(withId(R.id.addParticipationScore)).perform(typeText("1"));

        onView(withId(R.id.addParticipationButton)).perform(click());

        onData(allOf()).inAdapterView(withId(R.id.listview)).atPosition(1).perform(click());

        onData(allOf()).inAdapterView(withId(R.id.ParticipantsList)).atPosition(0).onChildView(withId(R.id.ParticipantListItemName)).check(matches(withText("TestName")));
        onData(allOf()).inAdapterView(withId(R.id.ParticipantsList)).atPosition(0).onChildView(withId(R.id.challengeListItemDescription)).check(matches(withText("1")));
    }
}
