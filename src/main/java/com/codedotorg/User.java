package com.codedotorg;

import java.util.ArrayList;

public class User {
    
    private String name;
    private ArrayList<Rating> ratings;

    public User(String name) {
        this.name = name;
        this.ratings = new ArrayList<Rating>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public void addRating(Movie movie, int score) {
        ratings.add(new Rating(this, movie, score));
    }

    public String toString() {
        return name + ": " + ratings.size() + " movies rated";
    }

}
