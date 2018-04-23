package com.gfee2.siddhi.signup_g2.view.adapter;

import android.app.Activity;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import com.gfee2.siddhi.signup_g2.view.ui.activities.AuthActivity;

public class IntroBindingAdapter {

  public void onClickSkipOrFinish(View view) {
    Log.e("onClickSkipOrFinish", "called");
    ((Activity) (view.getContext())).startActivity(new Intent(view.getContext(), AuthActivity.class));
    ((Activity) (view.getContext())).finish();
  }

  @BindingAdapter("onPageChangeListener")
  public static void setOnPageChangeListener(ViewPager viewPager,
      ViewPager.OnPageChangeListener listener) {
    Log.i("setOnPageChangeListener", "called");
    viewPager.clearOnPageChangeListeners();
    viewPager.addOnPageChangeListener(listener);
  }

  @BindingAdapter("changePage") public static void onClickNext(View view, ViewPager viewPager) {
    view.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
      }
    });
  }
}
