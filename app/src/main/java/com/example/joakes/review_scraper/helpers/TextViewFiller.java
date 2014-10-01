package com.example.joakes.review_scraper.helpers;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by joakes on 10/1/14.
 */
public class TextViewFiller {
    private Activity mActivity;

    public TextViewFiller(Activity activity){
        mActivity = activity;
    }

    public void setTextOrDisappear(int viewId, String text){
        TextView view = (TextView)mActivity.findViewById(viewId);
        if(text != null){
            view.setText(text);
        } else {
            view.setVisibility(View.GONE);
        }
    }

    public void setCorrectText(int viewId, String text, String defaultText){
        TextView view = (TextView)mActivity.findViewById(viewId);
        if(text != null){
            view.setText(text);
        } else {
            view.setText(defaultText);
        }
    }
}
