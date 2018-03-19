package com.gfee2.siddhi.signup_g2.view.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.gfee2.siddhi.signup_g2.R;
import com.gfee2.siddhi.signup_g2.view.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

  @Override public int getLayoutRes() {
    return 0;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }
}
