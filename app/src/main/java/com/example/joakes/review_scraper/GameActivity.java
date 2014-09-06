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

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;


public class GameActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_game);
//        ImageView imageView = (ImageView)findViewById(R.id.cover_art);
        final Context self = this;
        Ion.with(this)
                .load("http://reviewscraper.herokuapp.com/reviews/all/fallout-new-vegas")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        JsonArray reviews = result.getAsJsonArray("reviews");
//                        String url = ignResults.get("picture_link").getAsString();
//                        ImageView imageView = (ImageView)findViewById(R.id.cover_art);
//                        Ion.with(imageView)
//                                .placeholder(R.drawable.destiny)
//                                .error(R.drawable.destiny)
//                                .load(url);
//                        TextView textView = (TextView)findViewById(R.id.rating);
//                        String rating = ignResults.get("rating").getAsString();
//                        textView.setText(rating);
                        JsonObject[] values = new JsonObject[reviews.size()];
                        for (int i = 0; i <reviews.size(); i++){
                            values[i] = reviews.get(i).getAsJsonObject();
                        }
//                        values[0] = ignResults;
                        MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(self, values);
                        setListAdapter(adapter);
                    }
                });

//        Ion.with(imageView)
//                .placeholder(R.drawable.destiny)
//                .error(R.drawable.destiny)
////                .animateLoad(spinAnimation)
////                .animateIn(fadeInAnimation)
//                .load("http://static2.gamespot.com/uploads/scale_tiny/mig/2/1/9/3/2222193-falloutnewvegasboxartntsc.jpg");


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

    private class MySimpleArrayAdapter extends ArrayAdapter<JsonObject> {
        private final Context context;
        private final JsonObject[] values;

        public MySimpleArrayAdapter(Context context, JsonObject[] values) {
            super(context, R.layout.review_list_item3, values);
            this.context = context;
            this.values = values;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.review_list_item3, parent, false);
            TextView site = (TextView) rowView.findViewById(R.id.review_site);
            site.setText(values[position].get("site").getAsString());
            TextView rating = (TextView) rowView.findViewById(R.id.rating_value);
            rating.setText(values[position].get("rating").getAsString());
            TextView community_rating = (TextView) rowView.findViewById(R.id.community_rating_value);
            community_rating.setText(values[position].get("communityRating").getAsString());
            TextView rating_description = (TextView) rowView.findViewById(R.id.rating_description);
            rating_description.setText(values[position].get("ratingDescription").getAsString());
//            TextView community_rating_description = (TextView) rowView.findViewById(R.id.community_rating_description);
//            community_rating_description.setText(values[position].get("community_rating_description").getAsString());
            TextView review = (TextView) rowView.findViewById(R.id.review);
            review.setClickable(true);
            review.setMovementMethod(LinkMovementMethod.getInstance());
            String text = "<a href='"+ values[position].get("reviewLink").getAsString() + "'>Review</a>";
            review.setText(Html.fromHtml(text));
            TextView video_review = (TextView) rowView.findViewById(R.id.video_review);
            video_review.setClickable(true);
            video_review.setMovementMethod(LinkMovementMethod.getInstance());
//            String text2 = "<a href='"+ values[position].get("video_review_link").getAsString() + "'>Video Review</a>";
//            video_review.setText(Html.fromHtml(text2));
            return rowView;
        }
    }
}
