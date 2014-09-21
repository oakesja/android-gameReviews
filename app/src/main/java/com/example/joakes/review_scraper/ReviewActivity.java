package com.example.joakes.review_scraper;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;


public class ReviewActivity extends ListActivity {
    private static final String API_URL = "http://reviewscraper.herokuapp.com/reviews/all/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String chosen_game = intent.getStringExtra(MainActivity.CHOSEN_GAME).replace(" ", "%20");
        String url = API_URL + chosen_game;
        Log.i("Backend Call", url);

        try {
            Game game = Ion.with(this)
                    .load(url)
                    .as(Game.class)
                    .get();
            DescriptionFiller filler = new DescriptionFiller(game);
            filler.fillContextWithDescription(this);
            ReviewAdapter adapter = new ReviewAdapter(this, game.reviews);
            setListAdapter(adapter);
        } catch (Exception e){
            Log.e("Error Ion call", e.toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
