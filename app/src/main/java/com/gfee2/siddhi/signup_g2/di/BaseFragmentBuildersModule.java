package com.gfee2.siddhi.signup_g2.di;

import com.gfee2.siddhi.signup_g2.view.ui.base.BaseFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by siddhi on 3/23/2018.
 */

@Module public abstract class BaseFragmentBuildersModule {
  @ContributesAndroidInjector abstract BaseFragment contributeBaseFragment();
}
