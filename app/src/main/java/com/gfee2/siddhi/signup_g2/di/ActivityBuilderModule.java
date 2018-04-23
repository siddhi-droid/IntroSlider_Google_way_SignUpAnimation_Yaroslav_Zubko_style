package com.gfee2.siddhi.signup_g2.di;

import com.gfee2.siddhi.signup_g2.view.ui.activities.IntroActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by siddhi on 3/23/2018.
 */

@Module public abstract class ActivityBuilderModule {
  @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
  abstract IntroActivity mainActivity();
}
