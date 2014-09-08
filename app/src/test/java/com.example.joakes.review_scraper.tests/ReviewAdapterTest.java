package com.example.joakes.review_scraper.tests;

import android.test.AndroidTestCase;
import android.view.View;
import android.widget.TextView;

import com.example.joakes.review_scraper.R;
import com.example.joakes.review_scraper.Review;
import com.example.joakes.review_scraper.ReviewAdapter;
import com.example.joakes.review_scraper.ReviewBuilder;

import java.util.ArrayList;

/**
 * Created by joakes on 9/7/14.
 */
public class ReviewAdapterTest extends AndroidTestCase {
    private Review[] reviews;
    private TextView site;
    private TextView rating;
    private TextView communityRating;
    private TextView ratingDescription;
    private TextView communityRatingDescription;
    private TextView reviewLink;
    private TextView videoLink;

    protected void setUp() throws Exception {
        super.setUp();
        reviews = new Review[1];
    }

    public void testReviewAll(){
        Review review = new ReviewBuilder().withSite("site")
                .withRating("9.0")
                .withCommunityRating("8.9")
                .withRatingDescription("amazing")
                .withCommunityRatingDescription("great")
                .withReviewLink("review")
                .withVideoReviewLink("video")
                .build();
        setTextViews(review);
        assertEquals(review.site, site.getText());
        assertEquals(review.rating, rating.getText());
        assertEquals(review.communityRating, communityRating.getText());
        assertEquals(review.ratingDescription, ratingDescription.getText());
        assertEquals(review.communityRatingDescription, communityRatingDescription.getText());
        assertNotNull(reviewLink);
        assertNotNull(videoLink);
    }

    private void setTextViews(Review review){
        reviews[0] = review;
        ReviewAdapter adapter = new ReviewAdapter(getContext(), reviews);
        View view = adapter.getView(0, null, null);
        this.site = (TextView)view.findViewById(R.id.review_site);
        this.rating = (TextView)view.findViewById(R.id.rating_value);
        this.communityRating = (TextView)view.findViewById(R.id.community_rating_value);
        this.ratingDescription = (TextView)view.findViewById(R.id.rating_description);
        this.communityRatingDescription = (TextView)view.findViewById(R.id.community_rating_description);
        this.reviewLink = (TextView)view.findViewById(R.id.review_link);
        this.videoLink = (TextView)view.findViewById(R.id.video_review_link);
    }

}
