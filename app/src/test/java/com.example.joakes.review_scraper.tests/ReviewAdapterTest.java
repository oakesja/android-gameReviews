package com.example.joakes.review_scraper.tests;

import android.test.AndroidTestCase;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.example.joakes.review_scraper.R;
import com.example.joakes.review_scraper.Review;
import com.example.joakes.review_scraper.ReviewAdapter;
import com.example.joakes.review_scraper.ReviewBuilder;

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
    private String review_description;
    private String video_description;
    private String default_rating;
    private String default_site;

    protected void setUp() throws Exception {
        super.setUp();
        reviews = new Review[1];
        review_description = getContext().getString(R.string.review_link_description);
        video_description = getContext().getString(R.string.video_link_description);
        default_rating = getContext().getString(R.string.default_rating);
        default_site = getContext().getString(R.string.default_site);
    }

    public void testHaveAll(){
        Review review = new ReviewBuilder()
                .withSite("site")
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
        assertValidLink(reviewLink, review_description);
        assertValidLink(videoLink, video_description);
    }

    public void testMissingVideoLink(){
        Review review = new ReviewBuilder()
                .withSite("site")
                .withRating("9.0")
                .withCommunityRating("8.9")
                .withRatingDescription("amazing")
                .withCommunityRatingDescription("great")
                .withReviewLink("review")
                .build();
        setTextViews(review);
        assertEquals(review.site, site.getText());
        assertEquals(review.rating, rating.getText());
        assertEquals(review.communityRating, communityRating.getText());
        assertEquals(review.ratingDescription, ratingDescription.getText());
        assertEquals(review.communityRatingDescription, communityRatingDescription.getText());
        assertValidLink(reviewLink, review_description);
        assertEquals(View.GONE, videoLink.getVisibility());
    }

    public void testMissingReviewLink(){
        Review review = new ReviewBuilder()
                .withSite("site")
                .withRating("9.0")
                .withCommunityRating("8.9")
                .withRatingDescription("amazing")
                .withCommunityRatingDescription("great")
                .withVideoReviewLink("video")
                .build();
        setTextViews(review);
        assertEquals(review.site, site.getText());
        assertEquals(review.rating, rating.getText());
        assertEquals(review.communityRating, communityRating.getText());
        assertEquals(review.ratingDescription, ratingDescription.getText());
        assertEquals(review.communityRatingDescription, communityRatingDescription.getText());
        assertEquals(View.GONE, reviewLink.getVisibility());
        assertValidLink(videoLink, video_description);
    }

    public void testMissingCommunityRatingDescription(){
        Review review = new ReviewBuilder()
                .withSite("site")
                .withRating("9.0")
                .withCommunityRating("8.9")
                .withRatingDescription("amazing")
                .withReviewLink("review")
                .withVideoReviewLink("video")
                .build();
        setTextViews(review);
        assertEquals(review.site, site.getText());
        assertEquals(review.rating, rating.getText());
        assertEquals(review.communityRating, communityRating.getText());
        assertEquals(review.ratingDescription, ratingDescription.getText());
        assertEquals(View.INVISIBLE, communityRatingDescription.getVisibility());
        assertValidLink(reviewLink, review_description);
        assertValidLink(videoLink, video_description);
    }

    public void testMissingRatingDescription(){
        Review review = new ReviewBuilder()
                .withSite("site")
                .withRating("9.0")
                .withCommunityRating("8.9")
                .withCommunityRatingDescription("great")
                .withReviewLink("review")
                .withVideoReviewLink("video")
                .build();
        setTextViews(review);
        assertEquals(review.site, site.getText());
        assertEquals(review.rating, rating.getText());
        assertEquals(review.communityRating, communityRating.getText());
        assertEquals(View.INVISIBLE, ratingDescription.getVisibility());
        assertEquals(review.communityRatingDescription, communityRatingDescription.getText());
        assertValidLink(reviewLink, review_description);
        assertValidLink(videoLink, video_description);
    }

    public void testMissingBothDescriptions(){
        Review review = new ReviewBuilder()
                .withSite("site")
                .withRating("9.0")
                .withCommunityRating("8.9")
                .withReviewLink("review")
                .withVideoReviewLink("video")
                .build();
        setTextViews(review);
        assertEquals(review.site, site.getText());
        assertEquals(review.rating, rating.getText());
        assertEquals(review.communityRating, communityRating.getText());
        assertEquals(View.GONE, ratingDescription.getVisibility());
        assertEquals(View.GONE, communityRatingDescription.getVisibility());
        assertValidLink(reviewLink, review_description);
        assertValidLink(videoLink, video_description);
    }

    public void testMissingCommunityRating(){
        Review review = new ReviewBuilder()
                .withSite("site")
                .withRating("9.0")
                .withRatingDescription("amazing")
                .withCommunityRatingDescription("great")
                .withReviewLink("review")
                .withVideoReviewLink("video")
                .build();
        setTextViews(review);
        assertEquals(review.site, site.getText());
        assertEquals(review.rating, rating.getText());
        assertEquals(default_rating, communityRating.getText());
        assertEquals(review.ratingDescription, ratingDescription.getText());
        assertEquals(review.communityRatingDescription, communityRatingDescription.getText());
        assertValidLink(reviewLink, review_description);
        assertValidLink(videoLink, video_description);
    }

    public void testMissingRating(){
        Review review = new ReviewBuilder()
                .withSite("site")
                .withCommunityRating("8.9")
                .withRatingDescription("amazing")
                .withCommunityRatingDescription("great")
                .withReviewLink("review")
                .withVideoReviewLink("video")
                .build();
        setTextViews(review);
        assertEquals(review.site, site.getText());
        assertEquals(default_rating, rating.getText());
        assertEquals(review.communityRating, communityRating.getText());
        assertEquals(review.ratingDescription, ratingDescription.getText());
        assertEquals(review.communityRatingDescription, communityRatingDescription.getText());
        assertValidLink(reviewLink, review_description);
        assertValidLink(videoLink, video_description);
    }

    public void testMissingSite(){
        Review review = new ReviewBuilder()
                .withRating("9.0")
                .withCommunityRating("8.9")
                .withRatingDescription("amazing")
                .withCommunityRatingDescription("great")
                .withReviewLink("review")
                .withVideoReviewLink("video")
                .build();
        setTextViews(review);
        assertEquals(default_site, site.getText());
        assertEquals(review.rating, rating.getText());
        assertEquals(review.communityRating, communityRating.getText());
        assertEquals(review.ratingDescription, ratingDescription.getText());
        assertEquals(review.communityRatingDescription, communityRatingDescription.getText());
        assertValidLink(reviewLink, review_description);
        assertValidLink(videoLink, video_description);
    }

    private void assertValidLink(TextView link, String linkDescriptor){
        assertEquals(View.VISIBLE, link.getVisibility());
        assertEquals(LinkMovementMethod.getInstance(), link.getMovementMethod());
        assertEquals(true, link.getLinksClickable());
        assertEquals(linkDescriptor, link.getText().toString());
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
