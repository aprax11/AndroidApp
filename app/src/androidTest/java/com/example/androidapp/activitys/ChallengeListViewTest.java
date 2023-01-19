package com.example.androidapp.activitys;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.androidapp.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ChallengeListViewTest {

    @Rule
    public final ActivityScenarioRule<ChallengeOverviewActivity> scenarioRule =
            new ActivityScenarioRule<>(
                    new Intent(
                            InstrumentationRegistry.getInstrumentation().getTargetContext(),
                            ChallengeOverviewActivity.class)
                            .putExtra("MODE", "testScenario")
            );

    @Test
    public void listViewDataPosOneName_Test() {
        ActivityScenario<ChallengeOverviewActivity> scenario = scenarioRule.getScenario();

        onData(allOf())
                .inAdapterView(withId(R.id.listview))
                .atPosition(0)
                .onChildView(withId(R.id.ChallengeListItemName))
                .check(matches(withText("hardcodedTestChallenge")));
    }
    @Test
    public void listViewDataPosOneDescription_Test() {
        ActivityScenario<ChallengeOverviewActivity> scenario = scenarioRule.getScenario();

        onData(allOf())
                .inAdapterView(withId(R.id.listview))
                .atPosition(0)
                .onChildView(withId(R.id.challengeListItemDescription))
                .check(matches(withText("hardcodedTestChallengeDescription")));
    }
}
