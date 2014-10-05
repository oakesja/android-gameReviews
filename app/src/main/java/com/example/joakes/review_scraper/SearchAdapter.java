package com.example.joakes.review_scraper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

/**
 * Created by joakes on 10/5/14.
 */
public class SearchAdapter  extends ArrayAdapter<SearchResult> {
    private final Context context;
    private final SearchResult[] values;
    private View rowView;

    public SearchAdapter(Context context, SearchResult[] values) {
        super(context, R.layout.search_result, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        SearchResult result = values[position];
        rowView = inflater.inflate(R.layout.search_result, parent, false);
        TextView name = (TextView)rowView.findViewById(R.id.game_title);
        TextView platforms = (TextView)rowView.findViewById(R.id.platforms);
        ImageView coverArt = (ImageView)rowView.findViewById(R.id.cover_art);
        name.setText(result.gameName);
        platforms.setText(result.platforms);
        Ion.with(coverArt)
//                .placeholder(R.drawable.no_cover_art)
//                .error(R.drawable.no_cover_art)
                .load(result.pictureLink);
        return rowView;
    }
}