package com.jakewharton.u2020.data;

import android.app.Application;
import android.net.Uri;
import com.jakewharton.u2020.data.api.ReleaseApiModule;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;
import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

import javax.inject.Singleton;

@Module(
        includes = { ReleaseApiModule.class }
)
public final class ReleaseDataModule {

  @Provides @Singleton
  IntentFactory provideIntentFactory() {
    return IntentFactory.REAL;
  }

  @Provides @Singleton
  OkHttpClient provideOkHttpClient(Application app) {
    return DataModule.createOkHttpClient(app);
  }

  @Provides @Singleton
  Picasso providePicasso(Application app, OkHttpClient client) {
    return new Picasso.Builder(app)
        .downloader(new OkHttpDownloader(client))
        .listener(new Picasso.Listener() {
          @Override public void onImageLoadFailed(Picasso picasso, Uri uri, Exception e) {
            Timber.e(e, "Failed to load image: %s", uri);
          }
        })
        .build();
  }
}
