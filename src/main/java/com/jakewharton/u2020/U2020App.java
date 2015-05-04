package com.jakewharton.u2020;

import android.app.Application;
import android.support.annotation.NonNull;
import com.jakewharton.u2020.data.Injector;
import com.jakewharton.u2020.data.LumberYard;
import com.jakewharton.u2020.ui.ActivityHierarchyServer;
import javax.inject.Inject;
import net.danlew.android.joda.JodaTimeAndroid;
import timber.log.Timber;

import static timber.log.Timber.DebugTree;

public final class U2020App extends Application {
  private U2020Component component;

  @Inject ActivityHierarchyServer activityHierarchyServer;
  @Inject LumberYard lumberYard;

  @Override public void onCreate() {
    super.onCreate();
    JodaTimeAndroid.init(this);

    if (BuildConfig.DEBUG) {
      Timber.plant(new DebugTree());
    } else {
      // TODO Crashlytics.start(this);
      // TODO Timber.plant(new CrashlyticsTree());
    }

    component = buildComponent();
    component.inject(this);

    lumberYard.cleanUp();
    Timber.plant(lumberYard.tree());

    registerActivityLifecycleCallbacks(activityHierarchyServer);
  }

  protected U2020Component buildComponent() {
    return U2020Component.Builder.build(this);
  }

  @Override public Object getSystemService(@NonNull String name) {
    if (Injector.matchesService(name, U2020Component.class)) {
      return component;
    }
    return super.getSystemService(name);
  }
}
