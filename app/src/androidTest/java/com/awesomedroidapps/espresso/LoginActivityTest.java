/*
 * Copyright (c) 2016 Newshunt. All rights reserved.
 */
package com.awesomedroidapps.espresso;

import android.content.res.Resources;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * @author anshul.jain
 */
public class LoginActivityTest {

  @Rule
  public ActivityTestRule mActivityRule = new ActivityTestRule(LoginActivity.class);
  private Resources resources;

  @Before
  public void init() {
    resources = mActivityRule.getActivity().getResources();
  }

  @Test
  public void testSuccessfulLOGIN() {

    //Find a view with id user_name and type "Chandler" on that view.
    onView(withId(R.id.user_name)).perform(typeText("Chandler"));

    //Find a view with has hint Password and type "sarcasm" as password.
    onView(withHint("Password")).perform(typeText("sar"));

    //Close the keyword, otherwise LoginButton won't be visible to Espresso and it will throw an
    // exception.
    closeSoftKeyboard();

    //Find the LOGIN button and perform click().
    onView(allOf(withText("LOGIN"), isDescendantOfA(withId(R.id.linear_layout))))
        .perform(click());

    //Assert that the textView of LOGIN TextView has been changed to Success.
    String loginTxt = resources.getString(R.string.login_success);
    onView(allOf(withId(R.id.login_result))).check
        (matches(withText(loginTxt)));
  }

  @Test
  public void testFailedLOGIN() {

    //Find a view with id user_name and type "Ross" on that view.
    onView(withId(R.id.user_name)).perform(typeText("Ross"));

    //Find a view with has hint Password and type "marriage" as password.
    onView(withHint("Password")).perform(typeText("marriage"));

    //Close the keyword, otherwise LoginButton won't be visible to Espresso and it will throw an
    // exception.
    closeSoftKeyboard();

    //Find the LOGIN button and perform click().
    onView(allOf(withText("LOGIN"), isDescendantOfA(withId(R.id.linear_layout))))
        .perform(click());

    //Assert that the textView of LOGIN TextView has been changed to Success.
    String loginTxt = resources.getString(R.string.login_failure);
    onView(allOf(withId(R.id.login_result))).check
        (matches(withText(loginTxt)));
  }

}