package com.eread.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.eread.ProgressDialog;
import com.eread.R;
import com.eread.model.SearchBooksResponse;
import com.eread.presenter.BooksListPresenter;
import com.eread.services.EReadServiceGenerator;
import com.eread.view.adapter.BooksListAdapter;

public class SearchBooksActivity extends AppCompatActivity implements SearchBooksViewCallBack {


  BooksListPresenter booksListPresenter;
  public static final int NUM_OF_BOOKS_IN_A_ROW = 2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_books);

    booksListPresenter = new BooksListPresenter(EReadServiceGenerator.createService(), this);
  }


  public void searchBooks(View view) {
    EditText searchEditText = (EditText) findViewById(R.id.et_search_books);
    booksListPresenter.searchBooks(searchEditText.getText().toString());
  }

  @Override
  public void renderBooks(SearchBooksResponse searchBookResponse) {
    RecyclerView booksListView = (RecyclerView) findViewById(R.id.rc_books_list);
    booksListView.setVisibility(View.VISIBLE);
    BooksListAdapter booksListAdapter = new BooksListAdapter(searchBookResponse.getBooks());
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this, NUM_OF_BOOKS_IN_A_ROW);
    booksListView.setAdapter(booksListAdapter);
    booksListView.setLayoutManager(gridLayoutManager);
  }

  @Override
  public void hideWelcomeMessage() {
    findViewById(R.id.tv_welcome_text).setVisibility(View.GONE);
  }

  @Override
  public void showNoResultsFoundMessage() {
    findViewById(R.id.tv_no_result_found_text).setVisibility(View.VISIBLE);
  }

  @Override
  public void hideNoResultsFoundMessage() {
    findViewById(R.id.tv_no_result_found_text).setVisibility(View.GONE);
  }

  @Override
  public void hideSearchResult() {
    findViewById(R.id.rc_books_list).setVisibility(View.GONE);
  }

  @Override
  public void showProgressDialog() {
    ProgressDialog.show(this);
  }

  @Override
  public void hideProgressDialog() {
    ProgressDialog.dismissDialog();
  }
}
