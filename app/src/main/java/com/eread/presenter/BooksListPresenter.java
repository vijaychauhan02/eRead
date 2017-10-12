package com.eread.presenter;

import android.support.annotation.NonNull;

import com.eread.SearchBooksViewCallBack;
import com.eread.model.SearchBookResponse;
import com.eread.services.EReadServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BooksListPresenter {

  private EReadServices service;
  private SearchBooksViewCallBack searchBooksViewCallBack;

  public BooksListPresenter(EReadServices service, SearchBooksViewCallBack searchBooksViewCallBack) {
    this.service = service;
    this.searchBooksViewCallBack = searchBooksViewCallBack;
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
        searchBooksViewCallBack.renderBooks(response.body());
      }

      @Override
      public void onFailure(Call<SearchBookResponse> call, Throwable t) {
      }
    };
  }
}
