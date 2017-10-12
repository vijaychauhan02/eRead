package com.eread.presenter;

import android.support.annotation.NonNull;

import com.eread.model.SearchBookResponse;
import com.eread.services.EReadServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BooksListPresenter {

  private EReadServices service;

  public BooksListPresenter(EReadServices service) {
    this.service = service;
  }

  public void searchBooks(String searchQuery) {

    Call<SearchBookResponse> call = service.searchBooks(searchQuery);

    call.enqueue(getSearchBookResponseCallBack());

  }

  @NonNull
  private Callback<SearchBookResponse> getSearchBookResponseCallBack() {
    return new Callback<SearchBookResponse>() {
      @Override
      public void onResponse(Call<SearchBookResponse> call, Response<SearchBookResponse> response) {
      }

      @Override
      public void onFailure(Call<SearchBookResponse> call, Throwable t) {
      }
    };
  }
}
