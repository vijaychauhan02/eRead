package com.eread;

import com.eread.model.SearchBookResponse;

public interface SearchBooksViewCallBack {
  void renderBooks(SearchBookResponse searchBookResponse);
}
