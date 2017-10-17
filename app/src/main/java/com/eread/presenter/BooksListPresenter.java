package com.eread.presenter;

import android.support.annotation.NonNull;

import com.eread.model.SearchBooksResponse;
import com.eread.services.EReadServices;
import com.eread.view.SearchBooksViewCallBack;

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

    searchBooksViewCallBack.hideWelcomeMessage();
    searchBooksViewCallBack.showProgressDialog();

    Call<SearchBooksResponse> call = service.searchBooks(searchQuery);
    call.enqueue(getSearchBookResponseCallBack());
  }

  @NonNull
  private Callback<SearchBooksResponse> getSearchBookResponseCallBack() {
    return new Callback<SearchBooksResponse>() {
      @Override
      public void onResponse(Call<SearchBooksResponse> call, Response<SearchBooksResponse> response) {
        handleSearchSucessResponse(response.body());
      }

      @Override
      public void onFailure(Call<SearchBooksResponse> call, Throwable t) {
        handleSearchFailure();
      }
    };
  }

  private void handleSearchFailure() {
    searchBooksViewCallBack.hideProgressDialog();
  }

  private void handleSearchSucessResponse(SearchBooksResponse response) {
    if (response.getTotalBooks() == 0) {
      searchBooksViewCallBack.hideSearchResult();
      searchBooksViewCallBack.showNoResultsFoundMessage();
    } else {
      searchBooksViewCallBack.hideNoResultsFoundMessage();
      searchBooksViewCallBack.renderBooks(response);
    }
    searchBooksViewCallBack.hideProgressDialog();
  }
}
