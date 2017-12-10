package com.eread.view;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.eread.ProgressDialog;
import com.eread.R;
import com.eread.model.SearchBooksResponse;
import com.eread.presenter.BooksListPresenter;
import com.eread.services.EReadServiceGenerator;
import com.eread.view.adapter.BooksListAdapter;

public class SearchBooksActivity extends AppCompatActivity implements SearchBooksViewCallBack {


  BooksListPresenter booksListPresenter;
  public static final int NUM_OF_BOOKS_IN_A_ROW = 2;
  ProgressDialog progressDialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_books);

    setToolbar();

    booksListPresenter = new BooksListPresenter(EReadServiceGenerator.createService(), this);
  }

  private void setToolbar() {
    Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
    setSupportActionBar(toolbar);
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
    if (progressDialog == null) {
      progressDialog = new ProgressDialog(this);
    }
    progressDialog.show();
  }

  @Override
  public void hideProgressDialog() {
    progressDialog.dismissDialog();
  }

  @Override
  protected void onNewIntent(Intent intent) {
    setIntent(intent);
    handleIntent();
  }

  private void handleIntent() {
    Intent intent = getIntent();
    if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
      String query = intent.getStringExtra(SearchManager.QUERY);
      booksListPresenter.searchBooks(query);
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.search_book_activity_actions, menu);

    SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();

    searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
    searchView.setIconifiedByDefault(false);

    return true;
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    progressDialog.dismissDialog();
  }
}
