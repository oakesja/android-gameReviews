package com.example.joakes.review_scraper.tests;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.joakes.review_scraper.DescriptionFiller;
import com.example.joakes.review_scraper.Game;
import com.example.joakes.review_scraper.GameBuilder;
import com.example.joakes.review_scraper.GameDescription;
import com.example.joakes.review_scraper.GameDescriptionBuilder;
import com.example.joakes.review_scraper.R;
import com.example.joakes.review_scraper.ReviewActivity;

/**
 * Created by joakes on 9/14/14.
 */

public class DescriptionFillerTest extends ActivityInstrumentationTestCase2<ReviewActivity> {
    private Activity mActivity;
    private TextView title;
    private TextView avgRating;
    private TextView avgComRating;
    private ImageView coverArt;

    public DescriptionFillerTest(){
        super(ReviewActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();
        title = (TextView)mActivity.findViewById(R.id.game_title);
        avgRating = (TextView) mActivity.findViewById(R.id.average_rating);
        avgComRating = (TextView) mActivity.findViewById(R.id.average_community_rating);
        coverArt = (ImageView) mActivity.findViewById(R.id.cover_art);
    }

    @Override
    protected void tearDown() throws Exception {
        mActivity.finish();
        super.tearDown();
    }

    @UiThreadTest
    public void testDescriptionFillerAllValid(){
        GameDescription descr = new GameDescriptionBuilder()
                .withGameName("test")
                .withPictureLink("link")
                .build();
        Game game = new GameBuilder()
                .withDescription(descr)
                .withAverageRating("9.5")
                .withAverageCommunityRating("9.0")
                .build();
        new DescriptionFiller(mActivity).fillContextWithDescription(game);
        assertEquals("test", title.getText());
        assertEquals("9.5", avgRating.getText());
        assertEquals("9.0", avgComRating.getText());
    }

    @UiThreadTest
    public void testDescriptionFillerNoTitle(){
        GameDescription descr = new GameDescriptionBuilder()
                .withPictureLink("link")
                .build();
        Game game = new GameBuilder()
                .withDescription(descr)
                .withAverageRating("9.5")
                .withAverageCommunityRating("9.0")
                .build();
        new DescriptionFiller(mActivity).fillContextWithDescription(game);
        assertEquals(View.GONE, title.getVisibility());
        assertEquals("9.5", avgRating.getText());
        assertEquals("9.0", avgComRating.getText());

    }

    @UiThreadTest
    public void testDescriptionFillerMissingAvgRating() {
        GameDescription descr = new GameDescriptionBuilder()
                .withGameName("test")
                .withPictureLink("link")
                .build();
        Game game = new GameBuilder()
                .withDescription(descr)
                .withAverageCommunityRating("9.0")
                .build();
        new DescriptionFiller(mActivity).fillContextWithDescription(game);
        assertEquals("test", title.getText());
        assertEquals("-.-", avgRating.getText());
        assertEquals("9.0", avgComRating.getText());
    }

    @UiThreadTest
    public void testDescriptionFillerMissingAvgCommRating(){
        GameDescription descr = new GameDescriptionBuilder()
                .withGameName("test")
                .withPictureLink("link")
                .build();
        Game game = new GameBuilder()
                .withDescription(descr)
                .withAverageRating("9.5")
                .build();
        new DescriptionFiller(mActivity).fillContextWithDescription(game);
        assertEquals("test", title.getText());
        assertEquals("9.5", avgRating.getText());
        assertEquals("-.-", avgComRating.getText());
    }
}
