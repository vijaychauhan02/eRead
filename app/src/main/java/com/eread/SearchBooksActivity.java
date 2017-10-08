package com.eread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchBooksActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_books);
  }


  public void searchBooks(View view) {
    EditText searchEditText = (EditText) findViewById(R.id.et_search_books);
    Toast.makeText(this, searchEditText.getText().toString(), Toast.LENGTH_LONG).show();
  }
}
