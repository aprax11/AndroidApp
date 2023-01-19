package com.example.androidapp.activitys;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.androidapp.R;

import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {
    @Rule
    public final ActivityScenarioRule<MainActivity> scenarioRule =
            new ActivityScenarioRule<>(
                    new Intent(
                            InstrumentationRegistry.getInstrumentation().getTargetContext(),
                            MainActivity.class)
            );

    @Test
    public void isActivityInView_Test() {
        ActivityScenario<MainActivity> scenario = scenarioRule.getScenario();

        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()));
    }
    @Test
    public void isTitleTextDisplayed_Test() {
        ActivityScenario<MainActivity> scenario = scenarioRule.getScenario();

        onView(withId(R.id.titleText)).check(matches(isDisplayed()));
    }
    @Test
    public void isContinueButtonDisplayed_Test() {
        ActivityScenario<MainActivity> scenario = scenarioRule.getScenario();

        onView(withId(R.id.continueButton)).check(matches(isDisplayed()));
    }
    @Test
    public void continueButtonText_Test() {
        ActivityScenario<MainActivity> scenario = scenarioRule.getScenario();

        onView(withId(R.id.continueButton)).check(matches(withText("continue")));
    }

    //viewmodel
    @Test
    public void navigation_Test() {
        ActivityScenario<MainActivity> scenario = scenarioRule.getScenario();

        onView(withId(R.id.continueButton)).perform(click());
        onView(withId(R.id.challengeOverviewActivity)).check(matches(isDisplayed()));
    }
}
