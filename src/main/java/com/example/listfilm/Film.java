package com.example.listfilm;

public class Film {
    private String title;
    private int imageResId;

    public Film(String title, int imageResId) {
        this.title = title;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResId() {
        return imageResId;
    }
}
