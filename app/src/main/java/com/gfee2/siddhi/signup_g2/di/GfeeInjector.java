package com.gfee2.siddhi.signup_g2.di;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.gfee2.siddhi.signup_g2.app.GfeeApplication;
import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by siddhi on 3/22/2018.
 */

public class GfeeInjector {
  public GfeeInjector() {
  }

  public static void init(GfeeApplication gfeeApplication) {
    DaggerGfeeComponent.builder().application(gfeeApplication).build().inject(gfeeApplication);
    gfeeApplication.registerActivityLifecycleCallbacks(
        new Application.ActivityLifecycleCallbacks() {
          @Override public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

          }

          @Override public void onActivityStarted(Activity activity) {

          }

          @Override public void onActivityResumed(Activity activity) {

          }

          @Override public void onActivityPaused(Activity activity) {

          }

          @Override public void onActivityStopped(Activity activity) {

          }

          @Override public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

          }

          @Override public void onActivityDestroyed(Activity activity) {

          }
        });
  }

  private static void handleActivity(Activity activity) {
    if (activity instanceof HasSupportFragmentInjector) {
      AndroidInjection.inject(activity);
    }

    if (activity instanceof FragmentActivity) {
      ((FragmentActivity) activity).getSupportFragmentManager()
          .registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
            @Override public void onFragmentCreated(FragmentManager fm,
                android.support.v4.app.Fragment fragment, Bundle savedInstanceState) {
              if (fragment instanceof Injectable) {
                AndroidSupportInjection.inject(fragment);
              }
            }
          }, true);
    }
  }
}
