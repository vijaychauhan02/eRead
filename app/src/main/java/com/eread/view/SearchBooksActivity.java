package com.eread.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.eread.R;
import com.eread.presenter.BooksListPresenter;
import com.eread.services.EReadServiceGenerator;

public class SearchBooksActivity extends AppCompatActivity {


  BooksListPresenter booksListPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_books);

    booksListPresenter = new BooksListPresenter(EReadServiceGenerator.createService());
  }


  public void searchBooks(View view) {
    EditText searchEditText = (EditText) findViewById(R.id.et_search_books);
    booksListPresenter.searchBooks(searchEditText.getText().toString());
  }

}
