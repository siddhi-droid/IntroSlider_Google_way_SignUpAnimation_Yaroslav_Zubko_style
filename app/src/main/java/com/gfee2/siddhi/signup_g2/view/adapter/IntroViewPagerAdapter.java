package com.gfee2.siddhi.signup_g2.view.adapter;

import android.animation.ArgbEvaluator;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.gfee2.siddhi.signup_g2.R;
import com.gfee2.siddhi.signup_g2.databinding.ActivityMainBinding;

public class IntroViewPagerAdapter extends BaseObservable {
  private FragmentActivity fragmentActivity;
  private ActivityMainBinding activityMainBinding;
  private ImageView[] indicators;

  public IntroViewPagerAdapter(FragmentActivity fragmentActivity,
      ActivityMainBinding activityMainBinding) {
    this.fragmentActivity = fragmentActivity;
    this.activityMainBinding = activityMainBinding;

    indicators = new ImageView[] {
        activityMainBinding.introIndicator0, activityMainBinding.introIndicator1,
        activityMainBinding.introIndicator2
    };
    updateIndicators();
  }

  @Bindable public ViewPager.OnPageChangeListener getPageSelected() {

    final ArgbEvaluator evaluator = new ArgbEvaluator();
    final int[] colorList = new int[] {
        fragmentActivity.getResources().getColor(R.color.cyan),
        fragmentActivity.getResources().getColor(R.color.orange),
        fragmentActivity.getResources().getColor(R.color.green)
    };

    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.d("onPageScrolled", "called from viewPageAdapter" + " " + position);
        final int colorUpdate = (Integer) evaluator.evaluate(positionOffset, colorList[position],
            colorList[position == 2 ? position : position + 1]);
        activityMainBinding.container.setBackgroundColor(colorUpdate);
      }

      @Override public void onPageSelected(int position) {
        Log.d("onPageSelected", "called from viewPageAdapter" + " " + position);
        updateIndicators();
        switch (position) {
          case 0:
            activityMainBinding.container.setBackgroundColor(colorList[0]);
            break;
          case 1:
            activityMainBinding.container.setBackgroundColor(colorList[1]);
            break;
          case 2:
            activityMainBinding.container.setBackgroundColor(colorList[2]);
            break;
        }
        activityMainBinding.introBtnNext.setVisibility(position == 2 ? View.GONE : View.VISIBLE);
        activityMainBinding.introBtnFinish.setVisibility(position == 2 ? View.VISIBLE : View.GONE);
      }

      @Override public void onPageScrollStateChanged(int state) {

      }
    };
    return pageChangeListener;
  }

  private void updateIndicators() {
    for (int i = 0; i < indicators.length; i++) {
      indicators[i].setBackgroundResource(
          i == activityMainBinding.container.getCurrentItem() ? R.drawable.indicator_selected
              : R.drawable.indicator_unselected);
    }
  }
}
