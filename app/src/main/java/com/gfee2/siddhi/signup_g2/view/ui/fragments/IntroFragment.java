package com.gfee2.siddhi.signup_g2.view.ui.fragments;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import com.gfee2.siddhi.signup_g2.R;
import com.gfee2.siddhi.signup_g2.databinding.FragmentTaskIntroBinding;
import com.gfee2.siddhi.signup_g2.view.ui.base.BaseFragment;
import com.gfee2.siddhi.signup_g2.viewmodel.AppIntroViewModel;
import java.util.Random;
import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroFragment extends BaseFragment<AppIntroViewModel, FragmentTaskIntroBinding> {
  @Inject ViewModelProvider.Factory viewModelFactory;
  private static final String ARG_SECTION_NUMBER = "section_number";
  //int[] bgs = new int[]{R.drawable.ic_flight_24dp, R.drawable.ic_mail_24dp, R.drawable.ic_explore_24dp};
  int[] bgs = new int[]{R.drawable.test_1, R.drawable.test_2, R.drawable.test_4};

  public static IntroFragment newInstance(int sectionNumber) {
    Bundle args = new Bundle();
    IntroFragment fragment = new IntroFragment();
    args.putInt(ARG_SECTION_NUMBER, sectionNumber);
    fragment.setArguments(args);
    return fragment;
  }

  @Override public Class<AppIntroViewModel> getViewModel() {
    return AppIntroViewModel.class;
  }

  @Override public int getLayoutRes() {
    return R.layout.fragment_task_intro;
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    dataBinding.sectionLabel.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
    dataBinding.sectionImg.setBackgroundResource(bgs[getArguments().getInt(ARG_SECTION_NUMBER) - 1]);
    return dataBinding.getRoot();
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }
}
