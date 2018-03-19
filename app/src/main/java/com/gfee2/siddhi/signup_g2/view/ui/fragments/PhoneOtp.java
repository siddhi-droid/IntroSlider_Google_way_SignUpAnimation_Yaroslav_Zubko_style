package com.gfee2.siddhi.signup_g2.view.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gfee2.siddhi.signup_g2.R;
import com.gfee2.siddhi.signup_g2.view.ui.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneOtp extends BaseFragment {

  public PhoneOtp() {
    // Required empty public constructor
  }

  @Override public Class getViewModel() {
    return null;
  }

  @Override public int getLayoutRes() {
    return 0;
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_phone_otp, container, false);
  }
}
