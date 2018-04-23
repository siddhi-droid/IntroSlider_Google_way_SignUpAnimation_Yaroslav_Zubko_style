package com.gfee2.siddhi.signup_g2.view.ui.activities;

import android.os.Bundle;
import android.widget.ImageView;
import com.gfee2.siddhi.signup_g2.R;
import com.gfee2.siddhi.signup_g2.databinding.ActivityAuthBinding;
import com.gfee2.siddhi.signup_g2.view.ui.base.BaseActivity;
import java.util.List;

public class AuthActivity extends BaseActivity<ActivityAuthBinding> {
  protected List<ImageView> sharedElements;

  @Override public int getLayoutRes() {
    return R.layout.activity_auth;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
}
