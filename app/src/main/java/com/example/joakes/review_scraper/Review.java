package com.example.joakes.review_scraper;

/**
 * Created by joakes on 9/5/14.
 */
public class Review {
    public String site;
    public String rating;
    public String communityRating;
    public String ratingDescription;
    public String communityRatingDescription;
    public String reviewLink;
    public String videoReviewLink;

    public Review(String site, String rating, String communityRating,
                  String ratingDescription, String communityRatingDescription,
                  String reviewLink, String videoReviewLink) {
        this.site = site;
        this.rating = rating;
        this.communityRating = communityRating;
        this.ratingDescription = ratingDescription;
        this.communityRatingDescription = communityRatingDescription;
        this.reviewLink = reviewLink;
        this.videoReviewLink = videoReviewLink;
    }
}
