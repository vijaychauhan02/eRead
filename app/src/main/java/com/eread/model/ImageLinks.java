package com.eread.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageLinks {
  public String smallThumbnail;
  public String thumbnail;

  @BindingAdapter({"bind:imageUrl"})
  public static void loadImage(ImageView view, String imageUrl) {
    Picasso.with(view.getContext())
        .load(imageUrl)
        .placeholder(android.R.color.transparent)
        .into(view);
  }
}
