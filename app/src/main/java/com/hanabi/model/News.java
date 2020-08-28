package com.hanabi.model;

public class News {

    private String title;
    private int idImg;

    public News(String title, int idImg) {
        this.title = title;
        this.idImg = idImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }
}
