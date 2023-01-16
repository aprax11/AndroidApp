package com.example.androidapp.activitys;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.withSettings;

import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.androidapp.R;
import com.example.androidapp.model.IModel;
import com.example.androidapp.model.Model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(JUnit4.class)
public class AddChallengeFormTest {



    @Rule
    public final ActivityScenarioRule<AddChallengeForm> scenarioRule =
            new ActivityScenarioRule<>(
                    new Intent(
                            InstrumentationRegistry.getInstrumentation().getTargetContext(),
                            AddChallengeForm.class).putExtra("MODE", "testScenario")
            );

    @Test
    public void isActivityInView_Test() {
        ActivityScenario<AddChallengeForm> scenario = scenarioRule.getScenario();

        onView(withId(R.id.addChallengeForm)).check(matches(isDisplayed()));
    }
    @Test
    public void isChallengeNameEditTextDisplayed_Test() {
        ActivityScenario<AddChallengeForm> scenario = scenarioRule.getScenario();

        onView(withId(R.id.challengeName)).check(matches(isDisplayed()));
    }
    @Test
    public void isChallengeDescriptionEditTextDisplayed_Test() {
        ActivityScenario<AddChallengeForm> scenario = scenarioRule.getScenario();

        onView(withId(R.id.challengeDescription)).check(matches(isDisplayed()));
    }
    @Test
    public void isPostChallengeButtonDisplayed_Test() {
        ActivityScenario<AddChallengeForm> scenario = scenarioRule.getScenario();

        onView(withId(R.id.postChallengeButton)).check(matches(isDisplayed()));
    }
    @Test
    public void postChallengeButtonText_Test() {
        ActivityScenario<AddChallengeForm> scenario = scenarioRule.getScenario();

        onView(withId(R.id.postChallengeButton)).check(matches(withText("post Challenge")));
    }

}
