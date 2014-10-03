package com.example.joakes.review_scraper;

/**
 * Created by joakes on 9/7/14.
 */
public class GameDescriptionBuilder {
    public String gameName;
    public String releaseDate;
    public String gameDescription;
    public String platform;
    public String genre;
    public String publisher;
    public String developer;
    public String esrbLink;
    public String pictureLink;

    public GameDescriptionBuilder() {}

    public GameDescriptionBuilder withGameName(String gameName) {
        this.gameName = gameName;
        return this;
    }

    public GameDescriptionBuilder withReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public GameDescriptionBuilder withGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
        return this;
    }

    public GameDescriptionBuilder withPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public GameDescriptionBuilder withGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public GameDescriptionBuilder withPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public GameDescriptionBuilder withDeveloper(String developer) {
        this.developer = developer;
        return this;
    }

    public GameDescriptionBuilder withEsrbLink(String esrbLink) {
        this.esrbLink = esrbLink;
        return this;
    }

    public GameDescriptionBuilder withPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
        return this;
    }

    public GameDescription build() {
        GameDescription gameDescription = new GameDescription(gameName, releaseDate, this.gameDescription, platform, genre, publisher, developer, esrbLink, pictureLink);
        return gameDescription;
    }
}
