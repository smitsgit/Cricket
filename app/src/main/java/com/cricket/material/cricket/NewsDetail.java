package com.cricket.material.cricket;

public class NewsDetail {
    public String author;
    public String title;
    public String url;
    public String link;


    public NewsDetail(String author, String title, String url, String link) {
        this.author = author;
        this.title = title;
        this.url = url;
        this.link = link;
    }

    public String getUrl() {
        return url;
    }

    public String getLink() {
        return link;
    }
}
