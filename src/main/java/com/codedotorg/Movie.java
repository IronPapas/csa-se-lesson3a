package com.codedotorg;

import java.util.ArrayList;

public class Movie {
    
    private String title;
    private int releaseYear;
    private ArrayList<Rating> ratings;

    public Movie(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.ratings = new ArrayList<Rating>();
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public void addRating(User user, int score) {
        ratings.add(new Rating(user, this, score));
    }

    public double getAverageRating() {
        if (ratings.size() == 0) {
            return 0;
        }

        double total = 0;

        for (int index = 0; index < ratings.size(); index++) {
            total += ratings.get(index).getScore();
        }

        return total / ratings.size();
    }

    public String toString() {
        return title + " (" + releaseYear + "): " + getAverageRating();
    }

}
