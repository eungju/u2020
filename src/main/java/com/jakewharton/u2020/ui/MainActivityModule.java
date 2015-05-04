package com.jakewharton.u2020.ui;

import android.support.v4.widget.DrawerLayout;

import dagger.Module;
import dagger.Provides;

@Module
public final class MainActivityModule {
  private final MainActivity mainActivity;

  MainActivityModule(MainActivity mainActivity) {
    this.mainActivity = mainActivity;
  }

  @Provides @ActivityScope DrawerLayout provideDrawerLayout() {
    return mainActivity.drawerLayout;
  }
}
