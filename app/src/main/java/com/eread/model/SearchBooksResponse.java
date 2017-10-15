package com.eread.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchBooksResponse {

  public List<Book> getBooks() {
    return books;
  }

  @SerializedName("items")
  List<Book> books;


}
