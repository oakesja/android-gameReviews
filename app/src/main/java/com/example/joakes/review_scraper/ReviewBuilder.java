package com.example.joakes.review_scraper;

/**
 * Created by joakes on 9/7/14.
 */
public class ReviewBuilder {
    public String site;
    public String rating;
    public String communityRating;
    public String ratingDescription;
    public String communityRatingDescription;
    public String reviewLink;
    public String videoReviewLink;

    public ReviewBuilder() {}


    public ReviewBuilder withSite(String site) {
        this.site = site;
        return this;
    }

    public ReviewBuilder withRating(String rating) {
        this.rating = rating;
        return this;
    }

    public ReviewBuilder withCommunityRating(String communityRating) {
        this.communityRating = communityRating;
        return this;
    }

    public ReviewBuilder withRatingDescription(String ratingDescription) {
        this.ratingDescription = ratingDescription;
        return this;
    }

    public ReviewBuilder withCommunityRatingDescription(String communityRatingDescription) {
        this.communityRatingDescription = communityRatingDescription;
        return this;
    }

    public ReviewBuilder withReviewLink(String reviewLink) {
        this.reviewLink = reviewLink;
        return this;
    }

    public ReviewBuilder withVideoReviewLink(String videoReviewLink) {
        this.videoReviewLink = videoReviewLink;
        return this;
    }

    public Review build() {
        Review review = new Review(site, rating, communityRating, ratingDescription, communityRatingDescription, reviewLink, videoReviewLink);
        return review;
    }
}
