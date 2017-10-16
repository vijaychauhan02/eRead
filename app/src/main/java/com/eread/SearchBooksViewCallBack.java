package com.eread;

import com.eread.model.SearchBooksResponse;

public interface SearchBooksViewCallBack {
  void renderBooks(SearchBooksResponse searchBookResponse);

  void hideWelcomeMessage();

  void showNoResultsFoundMessage();

  void hideNoResultsFoundMessage();

  void hideSearchResult();
}
