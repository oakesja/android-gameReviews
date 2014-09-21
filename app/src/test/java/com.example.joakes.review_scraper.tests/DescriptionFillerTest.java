package com.example.joakes.review_scraper.tests;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import static org.mockito.Mockito.*;


import com.example.joakes.review_scraper.ReviewActivity;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.builder.GsonFutureBuilder;
import com.koushikdutta.ion.builder.LoadBuilder;


/**
 * Created by joakes on 9/14/14.
 */
public class DescriptionFillerTest extends ActivityInstrumentationTestCase2<ReviewActivity> {
    private Activity activity;
    private Ion ion;
    private LoadBuilder loadBuilder;
    private GsonFutureBuilder gsonFutureBuilder;

    DescriptionFillerTest(){
        super(ReviewActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(false);
        activity = getActivity();
        ion = mock(Ion.class);
        loadBuilder = mock(LoadBuilder.class);
        gsonFutureBuilder = mock(GsonFutureBuilder.class);
    }

    public void testDescriptionFiller(){
        when(ion.with()).
    }

}
