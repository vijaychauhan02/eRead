package com.eread.model;

import java.util.List;

public class VolumeInfo {
  public String getTitle() {
    return title;
  }

  public String title;
  public String subtitle;
  public List<String> authors = null;
  public String publisher;
  public String publishedDate;
  public String description;
  public Integer pageCount;
  public String printType;
  public List<String> categories = null;
  public Double averageRating;
  public Integer ratingsCount;
  public String maturityRating;
  public Boolean allowAnonLogging;
  public String contentVersion;
  public ImageLinks imageLinks;
  public String language;
  public String previewLink;
  public String infoLink;
  public String canonicalVolumeLink;
}
