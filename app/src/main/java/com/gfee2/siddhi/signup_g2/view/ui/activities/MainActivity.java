package com.gfee2.siddhi.signup_g2.view.ui.activities;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ZoomControls;
import com.gfee2.siddhi.signup_g2.R;
import com.gfee2.siddhi.signup_g2.databinding.ActivityMainBinding;
import com.gfee2.siddhi.signup_g2.utils.PageTransformer;
import com.gfee2.siddhi.signup_g2.view.adapter.IntroPagerAdapter;
import com.gfee2.siddhi.signup_g2.view.ui.base.BaseActivity;
import java.util.Random;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
  int page = 0;
  ImageView[] indicators;
  int colorUpdate;
  final ArgbEvaluator evaluator = new ArgbEvaluator();

  @Override public int getLayoutRes() {
    return R.layout.activity_main;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    final int[] colorList = new int[] {
        getResources().getColor(R.color.color_white), getResources().getColor(R.color.color_white),
        getResources().getColor(R.color.green)
    };
    dataBinding.container.setAdapter(new IntroPagerAdapter(getSupportFragmentManager()));
    dataBinding.container.setPageTransformer(true, new PageTransformer());
    dataBinding.container.setOffscreenPageLimit(3);
    dataBinding.container.setCurrentItem(page);

    indicators = new ImageView[] {
        dataBinding.introIndicator0, dataBinding.introIndicator1, dataBinding.introIndicator2
    };

    updateIndicators();

    dataBinding.container.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        colorUpdate = (Integer) evaluator.evaluate(positionOffset, colorList[position],
            colorList[position == 2 ? position : position + 1]);
        dataBinding.container.setBackgroundColor(colorUpdate);
      }

      @Override public void onPageSelected(int position) {
        page = position;

        updateIndicators();
        Log.e("position_changed", "" + position);
        switch (position) {
          case 0:
            dataBinding.container.setBackgroundColor(getResources().getColor(R.color.color_white));
            break;
          case 1:
            dataBinding.container.setBackgroundColor(getResources().getColor(R.color.color_white));
            break;
          case 2:
            dataBinding.container.setBackgroundColor(getResources().getColor(R.color.color_white));
            break;
        }
        dataBinding.introBtnNext.setVisibility(position == 2 ? View.GONE : View.VISIBLE);
        dataBinding.introBtnFinish.setVisibility(position == 2 ? View.VISIBLE : View.GONE);
      }

      @Override public void onPageScrollStateChanged(int state) {
      }
    });
  }

  private void updateIndicators() {
    for (int i = 0; i < indicators.length; i++) {
      indicators[i].setBackgroundResource(
          i == dataBinding.container.getCurrentItem() ? R.drawable.indicator_selected
              : R.drawable.indicator_unselected);
    }
  }
}
