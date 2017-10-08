package com.eread.services;

import com.eread.utils.Endpoints;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EReadServiceGenerator {

  public static EReadServices createService() {
    return RetrofitNetworkClient.getClient().create(EReadServices.class);
  }

  public static class RetrofitNetworkClient {

    static Retrofit getClient() {
      return new Retrofit.Builder()
          .baseUrl(Endpoints.BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }
  }
}
