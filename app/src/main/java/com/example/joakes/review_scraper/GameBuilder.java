package com.example.joakes.review_scraper;

/**
 * Created by joakes on 9/7/14.
 */
public class GameBuilder {
    public GameDescription description;
    public Review[] reviews;
    public String averageRating;
    public String averageCommunityRating;

    private GameBuilder() {}

    public GameBuilder withDescription(GameDescription description) {
        this.description = description;
        return this;
    }

    public GameBuilder withReviews(Review[] reviews) {
        this.reviews = reviews;
        return this;
    }

    public GameBuilder withAverageRating(String averageRating) {
        this.averageRating = averageRating;
        return this;
    }

    public GameBuilder withAverageCommunityRating(String averageCommunityRating) {
        this.averageCommunityRating = averageCommunityRating;
        return this;
    }

    public Game build() {
        Game game = new Game(description, reviews, averageRating, averageCommunityRating);
        return game;
    }
}
