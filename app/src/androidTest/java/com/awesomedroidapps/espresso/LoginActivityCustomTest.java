/*
 * Copyright (c) 2016 Newshunt. All rights reserved.
 */
package com.awesomedroidapps.espresso;

import android.content.Intent;
import android.content.res.Resources;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;

/**
 * @author anshul.jain
 */
public class LoginActivityCustomTest {

  @Rule
  public ActivityTestRule mActivityRule = new ActivityTestRule(LoginActivity.class, false, false);

  @Before
  public void init() {
    Intent intent = new Intent();
    intent.putExtra("key", "value");
    mActivityRule.launchActivity(intent);
  }

}