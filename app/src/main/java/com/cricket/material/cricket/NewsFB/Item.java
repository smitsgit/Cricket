package com.cricket.material.cricket.NewsFB;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "author",
    "description",
    "link",
    "newsid",
    "pubDate",
    "title",
    "thumburl"
})
public class Item {

    @JsonProperty("author")
    private String author;
    @JsonProperty("description")
    private String description;
    @JsonProperty("link")
    private String link;
    @JsonProperty("newsid")
    private String newsid;
    @JsonProperty("pubDate")
    private String pubDate;
    @JsonProperty("title")
    private String title;
    @JsonProperty("thumburl")
    private String thumburl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The author
     */
    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    /**
     * 
     * @param author
     *     The author
     */
    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The link
     */
    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    /**
     * 
     * @param link
     *     The link
     */
    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 
     * @return
     *     The newsid
     */
    @JsonProperty("newsid")
    public String getNewsid() {
        return newsid;
    }

    /**
     * 
     * @param newsid
     *     The newsid
     */
    @JsonProperty("newsid")
    public void setNewsid(String newsid) {
        this.newsid = newsid;
    }

    /**
     * 
     * @return
     *     The pubDate
     */
    @JsonProperty("pubDate")
    public String getPubDate() {
        return pubDate;
    }

    /**
     * 
     * @param pubDate
     *     The pubDate
     */
    @JsonProperty("pubDate")
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    /**
     * 
     * @return
     *     The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The thumburl
     */
    @JsonProperty("thumburl")
    public String getThumburl() {
        return thumburl;
    }

    /**
     * 
     * @param thumburl
     *     The thumburl
     */
    @JsonProperty("thumburl")
    public void setThumburl(String thumburl) {
        this.thumburl = thumburl;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
