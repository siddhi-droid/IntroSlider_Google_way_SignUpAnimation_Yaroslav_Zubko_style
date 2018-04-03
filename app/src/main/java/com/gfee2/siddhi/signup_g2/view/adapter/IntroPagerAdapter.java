package com.gfee2.siddhi.signup_g2.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.gfee2.siddhi.signup_g2.view.ui.fragments.TaskIntroFragment;

/**
 * Created by siddhi on 3/22/2018.
 */

public class IntroPagerAdapter extends FragmentStatePagerAdapter {

  public IntroPagerAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override public Fragment getItem(int position) {
    return TaskIntroFragment.newInstance(position + 1);
  }

  @Override public int getCount() {
    return 3;
  }

}
