package com.example.joakes.review_scraper;

import android.app.Activity;
import android.widget.ImageView;

import com.example.joakes.review_scraper.helpers.TextViewFiller;
import com.koushikdutta.ion.Ion;

/**
 * Created by joakes on 9/14/14.
 */
public class DescriptionFiller {
    private Game game;

    public DescriptionFiller(Game description){
        this.game = description;
    }

    public void fillContextWithDescription(Activity activity){
        ImageView coverArt = (ImageView)activity.findViewById(R.id.cover_art);
        //TODO add error and tests
        Ion.with(coverArt)
                .load(game.description.pictureLink);

        TextViewFiller tvf = new TextViewFiller(activity);
        String defaultRating = activity.getString(R.string.default_rating);
        tvf.setTextOrDisappear(R.id.game_title, game.description.gameName);
        tvf.setCorrectText(R.id.average_rating, game.averageRating, defaultRating);
        tvf.setCorrectText(R.id.average_community_rating, game.averageCommunityRating, defaultRating);
    }


}
