package com.example.joakes.review_scraper;

/**
 * Created by joakes on 10/5/14.
 */
public class SearchResult {
    public String gameName;
    public String platforms;
    public String pictureLink;
    public String lookupKey;

    public SearchResult(String gameName, String platforms, String pictureLink, String lookupKey) {
        this.gameName = gameName;
        this.platforms = platforms;
        this.pictureLink = pictureLink;
        this.lookupKey = lookupKey;
    }
}
