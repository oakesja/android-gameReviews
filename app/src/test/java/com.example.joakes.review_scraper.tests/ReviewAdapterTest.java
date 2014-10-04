package com.example.joakes.review_scraper.tests;

import android.test.AndroidTestCase;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.example.joakes.review_scraper.R;
import com.example.joakes.review_scraper.Review;
import com.example.joakes.review_scraper.ReviewAdapter;
import com.example.joakes.review_scraper.ReviewBuilder;

import static org.assertj.android.api.Assertions.assertThat;


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
                .withReviewLink("www.google.com")
                .withVideoReviewLink("www.google.com")
                .build();
        setTextViews(review);
        assertThat(site).hasText(review.site);
        assertThat(rating).hasText(review.rating);
        assertThat(communityRating).hasText(review.communityRating);
        assertThat(ratingDescription).hasText(review.ratingDescription);
        assertThat(communityRatingDescription).hasText(review.communityRatingDescription);
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
                .withReviewLink("www.google.com")
                .build();
        setTextViews(review);
        assertThat(site).hasText(review.site);
        assertThat(rating).hasText(review.rating);
        assertThat(communityRating).hasText(review.communityRating);
        assertThat(ratingDescription).hasText(review.ratingDescription);
        assertThat(communityRatingDescription).hasText(review.communityRatingDescription);
        assertValidLink(reviewLink, review_description);
        assertThat(videoLink).isGone();
    }

    public void testInvalidVideoLink(){
        Review review = new ReviewBuilder()
                .withSite("site")
                .withRating("9.0")
                .withCommunityRating("8.9")
                .withRatingDescription("amazing")
                .withCommunityRatingDescription("great")
                .withReviewLink("www.google.com")
                .withVideoReviewLink("/video/review")
                .build();
        setTextViews(review);
        assertThat(site).hasText(review.site);
        assertThat(rating).hasText(review.rating);
        assertThat(communityRating).hasText(review.communityRating);
        assertThat(ratingDescription).hasText(review.ratingDescription);
        assertThat(communityRatingDescription).hasText(review.communityRatingDescription);
        assertValidLink(reviewLink, review_description);
        assertThat(videoLink).isGone();
    }

    public void testMissingReviewLink(){
        Review review = new ReviewBuilder()
                .withSite("site")
                .withRating("9.0")
                .withCommunityRating("8.9")
                .withRatingDescription("amazing")
                .withCommunityRatingDescription("great")
                .withVideoReviewLink("www.google.com")
                .build();
        setTextViews(review);
        assertThat(site).hasText(review.site);
        assertThat(rating).hasText(review.rating);
        assertThat(communityRating).hasText(review.communityRating);
        assertThat(ratingDescription).hasText(review.ratingDescription);
        assertThat(communityRatingDescription).hasText(review.communityRatingDescription);
        assertThat(reviewLink).isGone();
        assertValidLink(videoLink, video_description);
    }

    public void testInvalidReviewLink(){
        Review review = new ReviewBuilder()
                .withSite("site")
                .withRating("9.0")
                .withCommunityRating("8.9")
                .withRatingDescription("amazing")
                .withCommunityRatingDescription("great")
                .withReviewLink("/review")
                .withVideoReviewLink("www.google.com")
                .build();
        setTextViews(review);
        assertThat(site).hasText(review.site);
        assertThat(rating).hasText(review.rating);
        assertThat(communityRating).hasText(review.communityRating);
        assertThat(ratingDescription).hasText(review.ratingDescription);
        assertThat(communityRatingDescription).hasText(review.communityRatingDescription);
        assertThat(reviewLink).isGone();
        assertValidLink(videoLink, video_description);
    }

    public void testMissingCommunityRatingDescription(){
        Review review = new ReviewBuilder()
                .withSite("site")
                .withRating("9.0")
                .withCommunityRating("8.9")
                .withRatingDescription("amazing")
                .withReviewLink("www.google.com")
                .withVideoReviewLink("www.google.com")
                .build();
        setTextViews(review);
        assertThat(site).hasText(review.site);
        assertThat(rating).hasText(review.rating);
        assertThat(communityRating).hasText(review.communityRating);
        assertThat(ratingDescription).hasText(review.ratingDescription);
        assertThat(communityRatingDescription).isInvisible();
        assertValidLink(reviewLink, review_description);
        assertValidLink(videoLink, video_description);
    }

    public void testMissingRatingDescription(){
        Review review = new ReviewBuilder()
                .withSite("site")
                .withRating("9.0")
                .withCommunityRating("8.9")
                .withCommunityRatingDescription("great")
                .withReviewLink("www.google.com")
                .withVideoReviewLink("www.google.com")
                .build();
        setTextViews(review);
        assertThat(site).hasText(review.site);
        assertThat(rating).hasText(review.rating);
        assertThat(communityRating).hasText(review.communityRating);
        assertThat(ratingDescription).isInvisible();
        assertThat(communityRatingDescription).hasText(review.communityRatingDescription);
        assertValidLink(reviewLink, review_description);
        assertValidLink(videoLink, video_description);
    }

    public void testMissingBothDescriptions(){
        Review review = new ReviewBuilder()
                .withSite("site")
                .withRating("9.0")
                .withCommunityRating("8.9")
                .withReviewLink("www.google.com")
                .withVideoReviewLink("www.google.com")
                .build();
        setTextViews(review);
        assertThat(site).hasText(review.site);
        assertThat(rating).hasText(review.rating);
        assertThat(communityRating).hasText(review.communityRating);
        assertThat(ratingDescription).isGone();
        assertThat(communityRatingDescription).isGone();
        assertValidLink(reviewLink, review_description);
        assertValidLink(videoLink, video_description);
    }

    public void testMissingCommunityRating(){
        Review review = new ReviewBuilder()
                .withSite("site")
                .withRating("9.0")
                .withRatingDescription("amazing")
                .withCommunityRatingDescription("great")
                .withReviewLink("www.google.com")
                .withVideoReviewLink("www.google.com")
                .build();
        setTextViews(review);
        assertThat(site).hasText(review.site);
        assertThat(rating).hasText(review.rating);
        assertThat(communityRating).hasText(default_rating);
        assertThat(ratingDescription).hasText(review.ratingDescription);
        assertThat(communityRatingDescription).hasText(review.communityRatingDescription);
        assertValidLink(reviewLink, review_description);
        assertValidLink(videoLink, video_description);
    }

    public void testMissingRating(){
        Review review = new ReviewBuilder()
                .withSite("site")
                .withCommunityRating("8.9")
                .withRatingDescription("amazing")
                .withCommunityRatingDescription("great")
                .withReviewLink("www.google.com")
                .withVideoReviewLink("www.google.com")
                .build();
        setTextViews(review);
        assertThat(site).hasText(review.site);
        assertThat(rating).hasText(default_rating);
        assertThat(communityRating).hasText(review.communityRating);
        assertThat(ratingDescription).hasText(review.ratingDescription);
        assertThat(communityRatingDescription).hasText(review.communityRatingDescription);
        assertValidLink(reviewLink, review_description);
        assertValidLink(videoLink, video_description);
    }

    public void testMissingSite(){
        Review review = new ReviewBuilder()
                .withRating("9.0")
                .withCommunityRating("8.9")
                .withRatingDescription("amazing")
                .withCommunityRatingDescription("great")
                .withReviewLink("www.google.com")
                .withVideoReviewLink("www.google.com")
                .build();
        setTextViews(review);
        assertThat(site).hasText(default_site);
        assertThat(rating).hasText(review.rating);
        assertThat(communityRating).hasText(review.communityRating);
        assertThat(ratingDescription).hasText(review.ratingDescription);
        assertThat(communityRatingDescription).hasText(review.communityRatingDescription);
        assertValidLink(reviewLink, review_description);
        assertValidLink(videoLink, video_description);
    }

    private void assertValidLink(TextView link, String linkDescriptor){
        assertThat(link).isVisible().isClickable();
        assertEquals(LinkMovementMethod.getInstance(), link.getMovementMethod());
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
