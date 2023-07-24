package com.codedotorg;

public class Rating {
    
    private User user;
    private Movie movie;
    private int score;

    public Rating(User user, Movie movie, int score) {
        this.user = user;
        this.movie = movie;
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getScore() {
        return score;
    }

}
