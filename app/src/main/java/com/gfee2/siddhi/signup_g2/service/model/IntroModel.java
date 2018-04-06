package com.gfee2.siddhi.signup_g2.service.model;

import android.widget.ImageView;

public class IntroModel {
  private boolean lastPage;
  private ImageView zero, one, two;
  private ImageView[] indicators;
  private int currentPage;
  private int offScreenPageLimit;
  private int onPageSelected;

  public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public int getOffScreenPageLimit() {
    return offScreenPageLimit;
  }

  public void setOffScreenPageLimit(int offScreenPageLimit) {
    this.offScreenPageLimit = offScreenPageLimit;
  }

  public int getOnPageSelected() {
    return onPageSelected;
  }

  public void setOnPageSelected(int onPageSelected) {
    this.onPageSelected = onPageSelected;
  }
}
