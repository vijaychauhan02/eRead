package com.eread.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.eread.SearchBooksViewCallBack;
import com.eread.model.SearchBooksResponse;
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

    Call<SearchBooksResponse> call = service.searchBooks(searchQuery);

    call.enqueue(getSearchBookResponseCallBack());

  }

  @NonNull
  private Callback<SearchBooksResponse> getSearchBookResponseCallBack() {
    return new Callback<SearchBooksResponse>() {
      @Override
      public void onResponse(Call<SearchBooksResponse> call, Response<SearchBooksResponse> response) {
        Log.e("title is ", response.body().getItems().get(0).getVolumeInfo().getTitle());
        searchBooksViewCallBack.renderBooks(response.body());
      }

      @Override
      public void onFailure(Call<SearchBooksResponse> call, Throwable t) {
      }
    };
  }
}
