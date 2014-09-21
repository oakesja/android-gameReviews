package com.example.joakes.review_scraper;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

/**
 * Created by joakes on 9/14/14.
 */
public class DescriptionFiller {
    private Game game;

    DescriptionFiller(Game description){
        this.game = description;
    }

    public void fillContextWithDescription(Activity activity){
        ImageView coverArt = (ImageView)activity.findViewById(R.id.cover_art);
        Ion.with(coverArt).load(game.description.pictureLink);
        TextView title = (TextView)activity.findViewById(R.id.game_title);
        title.setText(game.description.gameName);
        TextView avg_rating = (TextView)activity.findViewById(R.id.average_rating);
        avg_rating.setText(game.averageRating);
        TextView avg_com_rating = (TextView)activity.findViewById(R.id.average_community_rating);
        avg_com_rating.setText(game.averageCommunityRating);
    }
}
