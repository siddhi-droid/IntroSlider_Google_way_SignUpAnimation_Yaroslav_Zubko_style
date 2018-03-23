package com.gfee2.siddhi.signup_g2.viewmodel;

import android.arch.lifecycle.ViewModel;
import com.gfee2.siddhi.signup_g2.R;

/**
 * Created by siddhi on 3/22/2018.
 */

public class AppIntroViewModel extends ViewModel {
  private static final String ARG_SECTION_NUMBER = "section_number";
  int[] bgs = new int[]{ R.drawable.ic_flight_24dp, R.drawable.ic_mail_24dp, R.drawable.ic_explore_24dp};

  public static String getArgSectionNumber() {
    return ARG_SECTION_NUMBER;
  }

  public int[] getBgs() {
    return bgs;
  }

  public void setBgs(int[] bgs) {
    this.bgs = bgs;
  }
}
