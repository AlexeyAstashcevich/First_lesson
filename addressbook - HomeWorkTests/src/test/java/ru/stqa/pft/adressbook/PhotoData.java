package ru.stqa.pft.adressbook;

public class PhotoData {
  private final String photoDirectory;

  public PhotoData(String photoDirectory) {
    this.photoDirectory = photoDirectory;
  }

  public String getPhotoDirectory() {
    return photoDirectory;
  }
}
