package com.gfee2.siddhi.signup_g2.utils;

import java.util.Stack;

/**
 * Created by siddhi on 3/20/2018.
 */

public class FixedStack<T> extends Stack<T> {
  int maxSize = 0;

  @Override public T push(T object) {
    if (maxSize > size()) {
      return super.push(object);
    }
    return object;
  }

  public int getMaxSize() {
    return maxSize;
  }

  public void setMaxSize(int maxSize) {
    this.maxSize = maxSize;
  }
}
