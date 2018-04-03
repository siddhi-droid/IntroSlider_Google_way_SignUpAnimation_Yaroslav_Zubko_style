package com.gfee2.siddhi.signup_g2.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.widget.ImageView;
import com.gfee2.siddhi.signup_g2.R;
import com.gfee2.siddhi.signup_g2.service.repository.IntroRepo;
import javax.inject.Inject;

/**
 * Created by siddhi on 3/22/2018.
 */

public class AppIntroViewModel extends AndroidViewModel {
  private static final String ARG_SECTION_NUMBER = "section_number";
  private static final int pageLimit = 3;
  int[] bgs = new int[]{ R.drawable.ic_flight_24dp, R.drawable.ic_mail_24dp, R.drawable.ic_explore_24dp};
  ImageView[] indicators;
  private IntroRepo introRepo;

  public static String getArgSectionNumber() {
    return ARG_SECTION_NUMBER;
  }

  public int[] getBgs() {
    return bgs;
  }

  public void setBgs(int[] bgs) {
    this.bgs = bgs;
  }

  @Inject public AppIntroViewModel(IntroRepo introRepo, Application application) {
    super(application);
    this.introRepo = introRepo;
  }
}
