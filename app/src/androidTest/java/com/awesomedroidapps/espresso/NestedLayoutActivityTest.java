/*
 * Copyright (c) 2016 Newshunt. All rights reserved.
 */
package com.awesomedroidapps.espresso;

import android.content.res.Resources;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * @author anshul.jain
 */
public class NestedLayoutActivityTest {

  @Rule
  public ActivityTestRule mActivityRule = new ActivityTestRule(NestedLayoutActivity.class);

  @Test
  public void performClickOnTextView() {
    onView(withId(R.id.parent_container)).perform(new ViewAction() {

      @Override
      public Matcher<View> getConstraints() {
        return isDisplayed();
      }

      @Override
      public String getDescription() {
        return "Performing click";
      }

      @Override
      public void perform(UiController uiController, View view) {
        //The view which we got in argument is the same view which Espresso found using onView(withId(R.id.parent_container))
        LinearLayout parentLinearLayout = (LinearLayout) view;
        //Get the LinearLayout inside the LinearLayout
        LinearLayout childLinearLayout = (LinearLayout) parentLinearLayout.getChildAt(0);
        //Get the Button inside the inner LinearLayout
        TextView helloWordTextView = (TextView) childLinearLayout.getChildAt(0);
        helloWordTextView.performClick();
      }
    });
  }
}