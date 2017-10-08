package com.eread.services;

import com.eread.model.SearchBookResponse;
import com.eread.utils.Endpoints;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EReadServices {

  @GET(Endpoints.SEARCH_BOOKS)
  Call<SearchBookResponse> searchBooks(@Query("q") String query);

}
