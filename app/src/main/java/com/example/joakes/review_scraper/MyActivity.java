package com.example.joakes.review_scraper;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MyActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
//                openSearch();
                return true;
            case R.id.action_settings:
//                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /** Called when the user clicks the Send button */
    public void openPage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void getReviews(View view) {
        EditText emailEditText = (EditText) findViewById(R.id.edit_message);
        String game = emailEditText.getText().toString();
        if( game != null && !game.isEmpty()) {
            String urlString = "http://reviewscraper.herokuapp.com/reviews/ign/" + game;
            new CallAPI().execute(urlString);
        }
    }

    private class CallAPI extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {

            String urlString=params[0]; // URL to call
            StringBuilder builder;
            InputStream in;
            // HTTP Get
            try {
                URL url = new URL(urlString);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                in = new BufferedInputStream(urlConnection.getInputStream());
                InputStreamReader reader = new InputStreamReader(in);
                BufferedReader bufferedReader = new BufferedReader(reader);
                builder = new StringBuilder();
                String line = bufferedReader.readLine();
                while (line != null) {
                    builder.append(line);
                    line = bufferedReader.readLine();
                }
            } catch (Exception e ) {
                System.out.println(e.getMessage());
                return e.getMessage();
            }
            return builder.toString();
        }

        protected void onPostExecute(String result) {
            Intent intent = new Intent(getApplicationContext(), DisplayMessageActivity.class);
            intent.putExtra(EXTRA_MESSAGE, result);
            startActivity(intent);
        }
    }
}


