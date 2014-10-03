package com.example.joakes.review_scraper;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joakes.review_scraper.helpers.TextViewFiller;
import com.koushikdutta.ion.Ion;

/**
 * Created by joakes on 9/14/14.
 */
public class DescriptionFiller {
    private Activity activity;
    private TextViewFiller tvf;

    public DescriptionFiller(Activity activity){
        this.activity = activity;
        this.tvf = new TextViewFiller(activity);
    }

    public void fillContextWithDescription(Game game){
        ImageView coverArt = (ImageView)activity.findViewById(R.id.cover_art);
        //TODO add error and tests
        Ion.with(coverArt)
                .error(R.drawable.no_cover_art)
                .load(game.description.pictureLink);
        String defaultRating = activity.getString(R.string.default_rating);
        tvf.setTextOrDisappear(R.id.game_title, game.description.gameName);
        tvf.setCorrectText(R.id.average_rating, game.averageRating, defaultRating);
        tvf.setCorrectText(R.id.average_community_rating, game.averageCommunityRating, defaultRating);
    }


}
