package com.jakewharton.u2020.data.api;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import retrofit.Endpoint;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

@Module
public final class ApiModule {
  public static final String PRODUCTION_API_URL = "https://api.github.com";

  @Provides @Singleton RestAdapter provideRestAdapter(Endpoint endpoint,
      @Named("Api") OkHttpClient client, Gson gson) {
    return new RestAdapter.Builder() //
        .setClient(new OkClient(client)) //
        .setEndpoint(endpoint) //
        .setConverter(new GsonConverter(gson)) //
        .build();
  }
}
