package com.gfee2.siddhi.signup_g2.view.ui.fragments;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gfee2.siddhi.signup_g2.R;
import com.gfee2.siddhi.signup_g2.databinding.FragmentTaskIntroBinding;
import com.gfee2.siddhi.signup_g2.di.Injectable;
import com.gfee2.siddhi.signup_g2.view.ui.base.BaseFragment;
import com.gfee2.siddhi.signup_g2.viewmodel.AppIntroViewModel;
import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskIntroFragment extends BaseFragment<AppIntroViewModel, FragmentTaskIntroBinding> {
  @Inject ViewModelProvider.Factory viewModelFactory;
  private static final String ARG_SECTION_NUMBER = "section_number";

  public static TaskIntroFragment newInstance() {
    Bundle args = new Bundle();
    TaskIntroFragment fragment = new TaskIntroFragment();
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
        return dataBinding.getRoot();
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }
}
