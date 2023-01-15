package com.example.androidapp.activitys;





import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;



import android.content.Intent;

import androidx.test.core.app.ActivityScenario;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.androidapp.R;
import com.example.androidapp.model.Model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class ParticipantListInstrumentedTest {

    @Rule
    public final ActivityScenarioRule<ChallengeActivity> scenarioRule =
            new ActivityScenarioRule<>(
                    new Intent(
                            InstrumentationRegistry.getInstrumentation().getTargetContext(),
                            ChallengeActivity.class)
                            .putExtra("ID", "1")
                            .putExtra("CONTROL", new Model())
            );

    @Test
    public void listViewDataPosOneName_Test() {
        ActivityScenario<ChallengeActivity> scenario = scenarioRule.getScenario();

       onData(allOf()).inAdapterView(withId(R.id.ParticipantsList)).atPosition(1).onChildView(withId(R.id.ParticipantListItemName)).check(matches(withText("Arsch")));
    }
    @Test
    public void listViewDataPosOneScore_Test() {
        ActivityScenario<ChallengeActivity> scenario = scenarioRule.getScenario();

        onData(allOf()).inAdapterView(withId(R.id.ParticipantsList)).atPosition(1).onChildView(withId(R.id.ParticipantListItemScore)).check(matches(withText("4")));
    }


}
