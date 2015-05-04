package com.jakewharton.u2020.ui;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class InternalReleaseUiModule {
  @Provides @Singleton AppContainer provideAppContainer(
      TelescopeAppContainer telescopeAppContainer) {
    return telescopeAppContainer;
  }

    @Provides @Singleton
    ActivityHierarchyServer provideActivityHierarchyServer() {
        return ActivityHierarchyServer.NONE;
    }
}
