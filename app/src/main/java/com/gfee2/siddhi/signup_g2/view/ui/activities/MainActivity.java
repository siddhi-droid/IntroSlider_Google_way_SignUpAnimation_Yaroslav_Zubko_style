package com.gfee2.siddhi.signup_g2.view.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.gfee2.siddhi.signup_g2.R;
import com.gfee2.siddhi.signup_g2.databinding.ActivityMainBinding;
import com.gfee2.siddhi.signup_g2.view.adapter.IntroPagerAdapter;
import com.gfee2.siddhi.signup_g2.view.ui.base.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

  @Override public int getLayoutRes() {
    return R.layout.activity_main;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    dataBinding.container.setAdapter(new IntroPagerAdapter(getSupportFragmentManager()));
    dataBinding.container.setOffscreenPageLimit(3);
    dataBinding.container.setCurrentItem(0);
  }
}
