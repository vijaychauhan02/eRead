package com.eread.presenter;

import android.support.annotation.NonNull;

import com.eread.view.SearchBooksViewCallBack;
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
//        Log.e("title is ", response.body().getBooks().get(0).getVolumeInfo().getTitle());
        renderTheSearchResponse(response.body());
      }

      @Override
      public void onFailure(Call<SearchBooksResponse> call, Throwable t) {
      }
    };
  }

  private void renderTheSearchResponse(SearchBooksResponse response) {
    searchBooksViewCallBack.hideWelcomeMessage();
    if (response.getTotalBooks() == 0) {
      searchBooksViewCallBack.hideSearchResult();
      searchBooksViewCallBack.showNoResultsFoundMessage();
    } else {
      searchBooksViewCallBack.hideNoResultsFoundMessage();
      searchBooksViewCallBack.renderBooks(response);
    }
  }
}
