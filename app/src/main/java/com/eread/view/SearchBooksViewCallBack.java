package com.eread.view;

import com.eread.model.SearchBooksResponse;

public interface SearchBooksViewCallBack {
  void renderBooks(SearchBooksResponse searchBookResponse);

  void hideWelcomeMessage();

  void showNoResultsFoundMessage();

  void hideNoResultsFoundMessage();

  void hideSearchResult();

  void showProgressDialog();

  void hideProgressDialog();
}
