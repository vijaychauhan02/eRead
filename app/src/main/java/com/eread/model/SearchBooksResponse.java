package com.eread.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchBooksResponse {

  @SerializedName("items")
  private List<Book> books;

  @SerializedName("totalItems")
  private int totalBooks;


  public List<Book> getBooks() {
    return books;
  }

  public int getTotalBooks() {
    return totalBooks;
  }
}
