package com.gfee2.siddhi.signup_g2.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.util.ArrayMap;
import com.gfee2.siddhi.signup_g2.di.ViewModelSubComponent;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by siddhi on 3/22/2018.
 */

@Singleton public class GfeeViewModelFactory implements ViewModelProvider.Factory {

  private final ArrayMap<Class, Callable<? extends ViewModel>> creators;

  @Inject public GfeeViewModelFactory(final ViewModelSubComponent viewModelSubComponent) {
    creators = new ArrayMap<>();
    creators.put(AppIntroViewModel.class, () -> viewModelSubComponent.appIntroViewModel());
  }

  @NonNull @Override public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
    Callable<? extends ViewModel> creator = creators.get(modelClass);
    if (creator == null) {
      for (Map.Entry<Class, Callable<? extends ViewModel>> entry : creators.entrySet()) {
        if (modelClass.isAssignableFrom(entry.getKey())) {
          creator = entry.getValue();
          break;
        }
      }
    }
    if (creator == null) {
      throw new IllegalArgumentException("Unknown model class " + modelClass);
    }
    try {
      return (T) creator.call();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
