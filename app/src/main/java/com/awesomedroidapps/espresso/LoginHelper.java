/*
 * Copyright (c) 2016 Newshunt. All rights reserved.
 */
package com.awesomedroidapps.espresso;

/**
 * @author anshul.jain
 */
public class LoginHelper {

  public static boolean areCredentialsValid(String userName, String password) {

    if (Utils.isEmpty(userName) || Utils.isEmpty(password)) {
      return false;
    }

    if (userName.length() < 5 || password.length() < 5) {
      return false;
    }

    return true;
  }


}