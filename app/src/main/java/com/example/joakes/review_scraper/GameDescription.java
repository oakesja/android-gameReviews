package com.example.joakes.review_scraper;

/**
 * Created by joakes on 9/5/14.
 */
public class GameDescription {
    public String gameName;
    public String releaseDate;
    public String gameDescription;
    public String platform;
    public String genre;
    public String publisher;
    public String developer;
    public String esrbLink;
    public String pictureLink;

    public GameDescription(String gameName, String releaseDate,
                           String gameDescription, String platform,
                           String genre, String publisher,
                           String developer, String esrbLink,
                           String pictureLink) {
        this.gameName = gameName;
        this.releaseDate = releaseDate;
        this.gameDescription = gameDescription;
        this.platform = platform;
        this.genre = genre;
        this.publisher = publisher;
        this.developer = developer;
        this.esrbLink = esrbLink;
        this.pictureLink = pictureLink;
    }
}
