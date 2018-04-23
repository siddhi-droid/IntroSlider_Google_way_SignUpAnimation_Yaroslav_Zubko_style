package com.gfee2.siddhi.signup_g2.view.ui.activities;

import android.os.Bundle;
import com.gfee2.siddhi.signup_g2.R;
import com.gfee2.siddhi.signup_g2.databinding.ActivityMainBinding;
import com.gfee2.siddhi.signup_g2.utils.PageTransformer;
import com.gfee2.siddhi.signup_g2.view.adapter.IntroBindingAdapter;
import com.gfee2.siddhi.signup_g2.view.adapter.IntroPagerAdapter;
import com.gfee2.siddhi.signup_g2.view.adapter.IntroViewPagerAdapter;
import com.gfee2.siddhi.signup_g2.view.ui.base.BaseActivity;

public class IntroActivity extends BaseActivity<ActivityMainBinding> {
  int page = 0;

  @Override public int getLayoutRes() {
    return R.layout.activity_main;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    dataBinding.container.setAdapter(new IntroPagerAdapter(getSupportFragmentManager()));
    dataBinding.container.setPageTransformer(true, new PageTransformer());
    dataBinding.container.setOffscreenPageLimit(3);
    dataBinding.container.setCurrentItem(page);
    dataBinding.setHandler(new IntroBindingAdapter());
    dataBinding.setAdapter(new IntroViewPagerAdapter(this, dataBinding));
  }
}
