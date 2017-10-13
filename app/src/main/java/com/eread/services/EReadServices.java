package com.eread.services;

import com.eread.model.SearchBooksResponse;
import com.eread.utils.Endpoints;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EReadServices {

  @GET(Endpoints.SEARCH_BOOKS)
  Call<SearchBooksResponse> searchBooks(@Query("q") String query);

}
