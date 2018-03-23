package com.gfee2.siddhi.signup_g2.di;

import android.arch.lifecycle.ViewModelProvider;
import com.gfee2.siddhi.signup_g2.viewmodel.GfeeViewModelFactory;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by siddhi on 3/23/2018.
 */

@Module(subcomponents = ViewModelSubComponent.class) class GfeeModules {

  @Singleton @Provides ViewModelProvider.Factory provideViewModelFactory(ViewModelSubComponent.Builder viewModelSubComponent) {
    return new GfeeViewModelFactory(viewModelSubComponent.build());
  }
}
