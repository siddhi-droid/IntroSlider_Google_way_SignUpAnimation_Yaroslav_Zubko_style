package com.gfee2.siddhi.signup_g2.di;

import com.gfee2.siddhi.signup_g2.viewmodel.AppIntroViewModel;
import dagger.Subcomponent;

/**
 * Created by siddhi on 3/22/2018.
 */

@Subcomponent public interface ViewModelSubComponent {
  @Subcomponent.Builder interface Builder {
    ViewModelSubComponent build();
  }

  AppIntroViewModel appIntroViewModel();
}
