package com.jakewharton.u2020.data.api;

import com.squareup.okhttp.OkHttpClient;
import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;

import javax.inject.Named;
import javax.inject.Singleton;

@Module
public final class ReleaseApiModule {
  @Provides @Singleton
  Endpoint provideEndpoint() {
    return Endpoints.newFixedEndpoint(ApiModule.PRODUCTION_API_URL);
  }

  @Provides @Singleton @Named("Api") OkHttpClient provideApiClient(OkHttpClient client) {
    return client.clone();
  }

  @Provides @Singleton GithubService provideGithubService(RestAdapter restAdapter) {
    return restAdapter.create(GithubService.class);
  }
}
