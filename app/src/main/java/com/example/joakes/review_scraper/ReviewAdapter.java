package com.example.joakes.review_scraper;

import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Patterns;
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
    private View rowView;

    public ReviewAdapter(Context context, Review[] values) {
        super(context, R.layout.review_list_item3, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Review review = values[position];
        rowView = inflater.inflate(R.layout.review_list_item3, parent, false);
        handleTextViewWithDefault(R.id.review_site, review.site, context.getString(R.string.default_site));
        handleTextViewWithDefault(R.id.rating_value, review.rating, context.getString(R.string.default_rating));
        handleTextViewWithDefault(R.id.community_rating_value, review.communityRating, context.getString(R.string.default_rating));
        handleTextViewPair(R.id.rating_description, R.id.community_rating_description, review.ratingDescription, review.communityRatingDescription);
        handleLink(R.id.review_link, review.reviewLink, context.getString(R.string.review_link_description));
        handleLink(R.id.video_review_link, review.videoReviewLink, context.getString(R.string.video_link_description));
        return rowView;
    }

    // TODO use text view filler here
    private void handleTextViewWithDefault(int viewId, String text, String defaultText){
        TextView view = (TextView) rowView.findViewById(viewId);
        if(text != null){
            view.setText(text);
        } else{
            view.setText(defaultText);
        }
    }

    private void handleTextViewPair(int viewId1, int viewId2, String text1, String text2){
        TextView view1 = (TextView) rowView.findViewById(viewId1);
        TextView view2 = (TextView) rowView.findViewById(viewId2);
        if (text1 == null && text2 == null){
            view1.setVisibility(View.GONE);
            view2.setVisibility(View.GONE);
        } else if (text1 == null) {
            view1.setVisibility(View.INVISIBLE);
            view2.setText(text2);
        } else if (text2 == null){
            view1.setText(text1);
            view2.setVisibility(View.INVISIBLE);
        } else {
            view1.setText(text1);
            view2.setText(text2);
        }
    }

    private void handleLink(int viewId, String url, String linkDescriptor){
        TextView view = (TextView) rowView.findViewById(viewId);
        if (url == null || !Patterns.WEB_URL.matcher(url).matches()){
            view.setVisibility(View.GONE);
        } else {
            view.setMovementMethod(LinkMovementMethod.getInstance());
            String text = "<a href='"+ url + "'>" + linkDescriptor + "</a>";
            view.setText(Html.fromHtml(text));
        }
    }
}
