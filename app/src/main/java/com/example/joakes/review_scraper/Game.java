package com.example.joakes.review_scraper;

/**
 * Created by joakes on 9/5/14.
 */
public class Game {
    public GameDescription description;
    public Review[] reviews;
    public String averageRating;
    public String averageCommunityRating;

    Game(GameDescription description, Review[] reviews,
         String averageRating, String averageCommunityRating){
        this.description = description;
        this.reviews = reviews;
        this.averageRating = averageRating;
        this.averageCommunityRating = averageCommunityRating;
    }
}
