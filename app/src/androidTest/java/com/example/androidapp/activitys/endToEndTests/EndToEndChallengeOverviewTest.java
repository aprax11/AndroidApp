package com.example.androidapp.activitys.endToEndTests;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
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
public class EndToEndChallengeOverviewTest {

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

        onView(withId(R.id.buttonSearchForm)).perform(click());

        onView(withId(R.id.challengeName)).perform(typeText("EndToEndTest"));
        onView(withId(R.id.challengeDescription)).perform(typeText("EndToEndTestDescription"));
        onView(withId(R.id.postChallengeButton)).perform(click());

        onData(allOf()).inAdapterView(withId(R.id.listview)).atPosition(1).onChildView(withId(R.id.ChallengeListItemName)).check(matches(withText("EndToEndTest")));
        onData(allOf()).inAdapterView(withId(R.id.listview)).atPosition(1).onChildView(withId(R.id.challengeDescription)).check(matches(withText("EndToEndTestDescription")));
    }
}
