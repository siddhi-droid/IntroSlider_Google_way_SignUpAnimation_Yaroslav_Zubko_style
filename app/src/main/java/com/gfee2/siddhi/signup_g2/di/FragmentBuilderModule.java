package com.gfee2.siddhi.signup_g2.di;

import com.gfee2.siddhi.signup_g2.view.ui.base.BaseFragment;
import com.gfee2.siddhi.signup_g2.view.ui.fragments.TaskIntroFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by siddhi on 3/23/2018.
 */

@Module public abstract class FragmentBuilderModule {
  @ContributesAndroidInjector abstract TaskIntroFragment taskIntroFragment();
}
