package com.gfee2.siddhi.signup_g2.di;

import com.gfee2.siddhi.signup_g2.view.ui.base.BaseActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by siddhi on 3/23/2018.
 */

@Module public abstract class BaseActivityModule {
  @ContributesAndroidInjector(modules = BaseFragmentBuildersModule.class)
  abstract BaseActivity contributeBaseActivity();
}
