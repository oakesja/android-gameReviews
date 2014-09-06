package com.example.joakes.review_scraper.tests;

import com.google.gson.Gson;

import junit.framework.TestCase;

import com.example.joakes.review_scraper.Game;


public class GameTest extends TestCase {
    public void test(){
        Gson gson = new Gson();
        String input = "{\"averageRating\": \"9.0\", \"averageCommunityRating\": \"9.1\", \"description\": {\n" +
                "        \"publisher\": \"publisher\",\n" +
                "        \"pictureLink\": \"picture\",\n" +
                "        \"esrbLink\": \"esrb\",\n" +
                "        \"gameName\": \"game\",\n" +
                "        \"releaseDate\": \"date\",\n" +
                "        \"platform\": \"xbox\",\n" +
                "        \"gameDescription\": \"description\",\n" +
                "        \"genre\": \"genre\",\n" +
                "        \"developer\": \"developer\"\n" +
                "    }, \"reviews\": [\n" +
                "        {\n" +
                "            \"rating\": \"9.0\",\n" +
                "            \"communityRatingDescription\": \"Great\",\n" +
                "            \"site\": \"IGN\",\n" +
                "            \"ratingDescription\": \"Amazing\",\n" +
                "            \"reviewLink\": \"review\",\n" +
                "            \"videoReviewLink\": \"video\",\n" +
                "            \"communityRating\": \"8.8\"\n" +
                "        }]}";

        Game game = gson.fromJson(input, Game.class);
        assertEquals("9.0", game.averageRating);
        assertEquals("9.1", game.averageCommunityRating);
        assertEquals("publisher", game.description.publisher);
        assertEquals("picture", game.description.pictureLink);
        assertEquals("esrb", game.description.esrbLink);
        assertEquals("game", game.description.gameName);
        assertEquals("date", game.description.releaseDate);
        assertEquals("xbox", game.description.platform);
        assertEquals("description", game.description.gameDescription);
        assertEquals("genre", game.description.genre);
        assertEquals("developer", game.description.developer);
        assertEquals("9.0", game.reviews[0].rating);
        assertEquals("8.8", game.reviews[0].communityRating);
        assertEquals("Amazing", game.reviews[0].ratingDescription);
        assertEquals("Great", game.reviews[0].communityRatingDescription);
        assertEquals("review", game.reviews[0].reviewLink);
        assertEquals("video", game.reviews[0].videoReviewLink);
        assertEquals("IGN", game.reviews[0].site);
    }
}