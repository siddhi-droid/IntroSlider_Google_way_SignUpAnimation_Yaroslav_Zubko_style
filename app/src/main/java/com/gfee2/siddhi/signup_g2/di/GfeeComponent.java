package com.gfee2.siddhi.signup_g2.di;

import android.app.Application;
import com.gfee2.siddhi.signup_g2.app.GfeeApplication;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import javax.inject.Singleton;

/**
 * Created by siddhi on 3/23/2018.
 */

@Singleton @Component(modules = {
    AndroidInjectionModule.class, GfeeModules.class, BaseActivityModule.class
})
public interface GfeeComponent {
  @Component.Builder interface Builder {
    @BindsInstance Builder application(Application application);
    GfeeComponent build();
  }
  void inject(GfeeApplication gfeeApplication);
}
