package com.example.androidapp.activitys;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.allOf;

import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.androidapp.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)



public class ChallengeOverviewActivityTest {

    @Rule
    public final ActivityScenarioRule<ChallengeOverviewActivity> scenarioRule =
            new ActivityScenarioRule<>(
                    new Intent(
                            InstrumentationRegistry.getInstrumentation().getTargetContext(),
                            ChallengeOverviewActivity.class)
                            .putExtra("MODE", "testScenario")
            );
    @Test
    public void isActivityInView_Test() {
        ActivityScenario<ChallengeOverviewActivity> scenario = scenarioRule.getScenario();

        onView(withId(R.id.challengeOverviewActivity)).check(matches(isDisplayed()));
    }
    @Test
    public void isListViewDisplayed_Test() {
        ActivityScenario<ChallengeOverviewActivity> scenario = scenarioRule.getScenario();

        onView(withId(R.id.listview)).check(matches(isDisplayed()));
    }
    //viewModel
    @Test
    public void listViewNavigation_Test() {
        ActivityScenario<ChallengeOverviewActivity> scenario = scenarioRule.getScenario();
        onData(allOf()).inAdapterView(withId(R.id.listview)).atPosition(0).perform(click());

        onView(withId(R.id.challengeActivity)).check(matches(isDisplayed()));
    }
    @Test
    public void isButtonDisplayed_Test() {
        ActivityScenario<ChallengeOverviewActivity> scenario = scenarioRule.getScenario();

        onView(withId(R.id.buttonSearchForm)).check(matches(isDisplayed()));
    }
    @Test
    public void buttonTextDisplayed_Test() {
        ActivityScenario<ChallengeOverviewActivity> scenario = scenarioRule.getScenario();

        onView(withId(R.id.buttonSearchForm)).check(matches(withText("post Challenge")));
    }
    @Test
    public void buttonNavigation_Test() {
        ActivityScenario<ChallengeOverviewActivity> scenario = scenarioRule.getScenario();

        onView(withId(R.id.buttonSearchForm)).perform(click());

        onView(withId(R.id.addChallengeForm)).check(matches(isDisplayed()));
    }
    @Test
    public void isRefreshButtonDisplayed_Test() {
        ActivityScenario<ChallengeOverviewActivity> scenario = scenarioRule.getScenario();

        onView(withId(R.id.refreshButton)).check(matches(isDisplayed()));
    }
    @Test
    public void reloadButtonText_Test() {
        ActivityScenario<ChallengeOverviewActivity> scenario = scenarioRule.getScenario();

        onView(withId(R.id.refreshButton)).check(matches(withText("refresh")));
    }
}