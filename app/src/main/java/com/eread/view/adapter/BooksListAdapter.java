package com.eread.view.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.eread.BR;
import com.eread.R;
import com.eread.model.Book;

import java.util.List;

public class BooksListAdapter extends RecyclerView.Adapter<BooksListAdapter.BooksListViewHolder>{

  private final List<Book> booksList;

  public BooksListAdapter(List<Book> booksList) {
    this.booksList = booksList;
  }

  @Override
  public BooksListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ViewDataBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
        R.layout.books_list_item, parent, false);
    return new BooksListViewHolder(dataBinding);
  }

  @Override
  public void onBindViewHolder(BooksListViewHolder holder, int position) {
    holder.render(booksList.get(position));
  }


  @Override
  public int getItemCount() {
    return booksList.size();
  }


  class BooksListViewHolder extends RecyclerView.ViewHolder{

    private ViewDataBinding binding;

    BooksListViewHolder(ViewDataBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    void render(Book book) {
      binding.setVariable(BR.book, book.getVolumeInfo());
    }
  }
}
