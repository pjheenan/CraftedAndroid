package com.philheenan.palletise.feature.account.authentication;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;

import com.philheenan.palletise.R;

import org.hamcrest.Matchers;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;

/**
 * Created by phillip.heenan on 12/03/15.
 */
public class AuthenticationActivityTest extends ActivityInstrumentationTestCase2<AuthenticationActivity> {

    public AuthenticationActivityTest() {
        super(AuthenticationActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testFormView() throws Exception {
        onView(withId(R.id.formView)).check(matches(isDisplayed()));
        onView(withId(R.id.username)).check(matches(isClickable()));
        onView(withId(R.id.password)).check(matches(isClickable()));
        onView(withId(R.id.button)).check(matches(Matchers.not(isEnabled())));
        onView(withId(R.id.progressLayout)).check(matches(Matchers.not(isDisplayed())));
    }

    public void testEnableButton() throws Exception {
        onView(withId(R.id.formView)).check(matches(isDisplayed()));
        onView(withId(R.id.username)).perform(ViewActions.typeText("user"));
        onView(withId(R.id.password)).perform(ViewActions.typeText("pass"));
        onView(withId(R.id.button)).check(matches(isEnabled()));
    }
}
