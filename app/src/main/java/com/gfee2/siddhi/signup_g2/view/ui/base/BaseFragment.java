package com.gfee2.siddhi.signup_g2.view.ui.base;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import dagger.android.AndroidInjection;
import javax.inject.Inject;

/**
 * Created by siddhi on 3/16/2018.
 */

public abstract class BaseFragment<VM extends ViewModel, DB extends ViewDataBinding> extends
    Fragment implements LifecycleRegistryOwner{

  private LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

  @Inject ViewModelProvider.Factory viewModelFactory;

  public VM viewModel;
  public DB dataBinding;

  public abstract Class<VM> getViewModel();

  @LayoutRes public abstract int getLayoutRes();

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    AndroidInjection.inject(this.getActivity());
    super.onCreate(savedInstanceState);
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel());
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    dataBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
    return dataBinding.getRoot();
  }

  @Override public LifecycleRegistry getLifecycle() {
    return lifecycleRegistry;
  }
}
