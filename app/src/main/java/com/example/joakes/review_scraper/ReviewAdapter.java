package com.example.joakes.review_scraper;

import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by joakes on 9/6/14.
 */
public class ReviewAdapter extends ArrayAdapter<Review> {
    private final Context context;
    private final Review[] values;

    public ReviewAdapter(Context context, Review[] values) {
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
        site.setText(values[position].site);
        TextView rating = (TextView) rowView.findViewById(R.id.rating_value);
        rating.setText(values[position].rating);
        TextView community_rating = (TextView) rowView.findViewById(R.id.community_rating_value);
        community_rating.setText(values[position].communityRating);
        TextView rating_description = (TextView) rowView.findViewById(R.id.rating_description);
        rating_description.setText(values[position].ratingDescription);
        TextView community_rating_description = (TextView) rowView.findViewById(R.id.community_rating_description);
        community_rating_description.setText(values[position].communityRatingDescription);
        TextView review = (TextView) rowView.findViewById(R.id.review);
        review.setClickable(true);
        review.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='"+ values[position].reviewLink + "'>Review</a>";
        review.setText(Html.fromHtml(text));
        TextView video_review = (TextView) rowView.findViewById(R.id.video_review);
        video_review.setClickable(true);
        video_review.setMovementMethod(LinkMovementMethod.getInstance());
        String text2 = "<a href='"+ values[position].videoReviewLink + "'>Video Review</a>";
        video_review.setText(Html.fromHtml(text2));
        return rowView;
    }
}
