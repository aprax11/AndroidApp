package com.example.androidapp.activitys.integrationTests;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.example.androidapp.R;
import com.example.androidapp.activitys.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)

public class MainActivityTest {
    @Test
    public void isActivityInView_Test() {
        ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }
    @Test
    public void isListViewDisplayed_Test() {
        ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(withId(R.id.listview)).check(matches(isDisplayed()));
    }
    @Test
    public void isButtonDisplayed_Test() {
        ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(withId(R.id.buttonSearchForm)).check(matches(isDisplayed()));
    }
    @Test
    public void buttonTextDisplayed_Test() {
        ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(withId(R.id.buttonSearchForm)).check(matches(withText("post Challenge")));
    }
    @Test
    public void buttonNavigation_Test() {
        ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(withId(R.id.buttonSearchForm)).perform(click());

        onView(withId(R.id.addChallengeForm)).check(matches(isDisplayed()));
    }
}