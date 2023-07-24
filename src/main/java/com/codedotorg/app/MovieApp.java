package com.codedotorg.app;

import com.codedotorg.Movie;
import com.codedotorg.MovieDatabase;
import com.codedotorg.User;

import javafx.stage.Stage;
import java.util.ArrayList;

public class MovieApp {
    
    private Stage window;
    private static WelcomeScreen welcomeScreen;
    private static MainScreen mainScreen;
    private static ViewMoviesScreen viewMoviesScreen;
    private static RateMovieScreen rateMovieScreen;
    private static ViewUsersScreen viewUsersScreen;
    private static UserRatingsScreen userRatingsScreen;

    private static ArrayList<Movie> movies;
    private static ArrayList<User> users;
    private static User currentUser;

    public MovieApp() {
        users = new ArrayList<User>();
        movies = MovieDatabase.createMovieList();
        currentUser = null;

        welcomeScreen = new WelcomeScreen();
        mainScreen = new MainScreen();
        viewMoviesScreen = new ViewMoviesScreen();
        rateMovieScreen = new RateMovieScreen();
        viewUsersScreen = new ViewUsersScreen();
        userRatingsScreen = new UserRatingsScreen();
    }

    public void startApp(Stage primaryStage) {
        this.window = primaryStage;
        window.setTitle("FlixRate");
        welcomeScreen.showWelcomeScreen(window);
    }

    public static WelcomeScreen getWelcomeScreen() {
        return welcomeScreen;
    }

    public static MainScreen getMainScreen() {
        return mainScreen;
    }

    public static ViewMoviesScreen getViewMoviesScreen() {
        return viewMoviesScreen;
    }

    public static RateMovieScreen getRateMovieScreen() {
        return rateMovieScreen;
    }

    public static ViewUsersScreen getViewUsersScreen() {
        return viewUsersScreen;
    }

    public static UserRatingsScreen getUserRatingsScreen() {
        return userRatingsScreen;
    }

    public static void setCurrentUser(User newUser) {
        currentUser = newUser;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static ArrayList<Movie> getMovies() {
        return movies;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void addUser(User newUser) {
        users.add(newUser);
    }

}
