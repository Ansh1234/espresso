/*
 * Copyright (c) 2016 Newshunt. All rights reserved.
 */
package com.awesomedroidapps.espresso;

/**
 * @author anshul.jain
 */
public class Utils {

  public static boolean isEmpty(String str) {
    if (str == null || str.equals("")) {
      return true;
    }
    return false;
  }
}