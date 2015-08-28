
package com.cricket.material.cricket.News;

import java.util.HashMap;
import java.util.Map;

public class Item {

    private String author;
    private String link;
    private String pubDate;
    private String title;
    private String description;
    private String newsid;
    private String thumburl;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();



    public String getAuthor() {
        return author;
    }



    public void setAuthor(String author) {
        this.author = author;
    }



    public String getLink() {
        return link;
    }



    public void setLink(String link) {
        this.link = link;
    }



    public String getPubDate() {
        return pubDate;
    }



    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }



    public String getTitle() {
        return title;
    }



    public void setTitle(String title) {
        this.title = title;
    }



    public String getDescription() {
        return description;
    }



    public void setDescription(String description) {
        this.description = description;
    }



    public String getNewsid() {
        return newsid;
    }



    public void setNewsid(String newsid) {
        this.newsid = newsid;
    }



    public String getThumburl() {
        return thumburl;
    }



    public void setThumburl(String thumburl) {
        this.thumburl = thumburl;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
