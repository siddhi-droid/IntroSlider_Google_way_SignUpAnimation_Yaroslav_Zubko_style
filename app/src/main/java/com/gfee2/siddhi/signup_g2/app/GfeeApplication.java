package com.gfee2.siddhi.signup_g2.app;

import android.app.Activity;
import android.app.Application;
import com.gfee2.siddhi.signup_g2.di.GfeeInjector;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import javax.inject.Inject;

/**
 * Created by siddhi on 3/22/2018.
 */

public class GfeeApplication extends Application implements HasActivityInjector {

  @Inject DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

  @Override public void onCreate() {
    super.onCreate();
    GfeeInjector.init(this);
  }

  @Override public DispatchingAndroidInjector<Activity> activityInjector() {
    return dispatchingAndroidInjector;
  }
}
