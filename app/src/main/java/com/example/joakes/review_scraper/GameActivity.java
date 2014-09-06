package com.example.joakes.review_scraper;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;


public class GameActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        final Context self = this;
        Ion.with(this)
                .load("http://reviewscraper.herokuapp.com/reviews/all/fallout-new-vegas")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        Gson gson = new Gson();
                        Game game = gson.fromJson(result, Game.class);
                        ImageView coverArt = (ImageView)findViewById(R.id.cover_art);
                        Ion.with(coverArt)
//                                .placeholder(R.drawable.destiny)
//                                .error(R.drawable.destiny)
                                .load(game.description.pictureLink);
                        TextView textView = (TextView)findViewById(R.id.rating);
                        textView.setText(game.averageRating);
                        ReviewAdapter adapter = new ReviewAdapter(self, game.reviews);
                        setListAdapter(adapter);
                    }
                });
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
