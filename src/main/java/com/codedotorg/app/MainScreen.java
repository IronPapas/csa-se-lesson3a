package com.codedotorg.app;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainScreen {

    private Label greetingLabel;
    private Button viewMoviesButton;
    private Button rateMovieButton;
    private Button viewUsersButton;
    private Button switchUserButton;
    private Button userRatingsButton;
    private Button quitButton;
    private Scene mainScene;

    public MainScreen() {
        greetingLabel = new Label();
        viewMoviesButton = new Button("View Movies");
        rateMovieButton = new Button("Rate a Movie");
        viewUsersButton = new Button("View Users");
        switchUserButton = new Button("Switch User");
        userRatingsButton = new Button("View Your Ratings");
        quitButton = new Button("Quit");
    }
    
    public void showMainScreen(Stage window) {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        
        greetingLabel.setText("Hi " + MovieApp.getCurrentUser().getName() + "!");
        setButtonActions(window);

        layout.getChildren().addAll(greetingLabel, viewMoviesButton, rateMovieButton, viewUsersButton, switchUserButton, userRatingsButton, quitButton);
        setScene(window, layout);
    }

    private void setButtonActions(Stage window) {
        viewMoviesButton.setOnAction(e -> MovieApp.getViewMoviesScreen().showViewMoviesScreen(window));
        rateMovieButton.setOnAction(e -> MovieApp.getRateMovieScreen().showRateMovieScene(window));
        viewUsersButton.setOnAction(e -> MovieApp.getViewUsersScreen().showViewUsersScreen(window));
        switchUserButton.setOnAction(e -> MovieApp.getWelcomeScreen().showWelcomeScreen(window));
        userRatingsButton.setOnAction(e -> MovieApp.getUserRatingsScreen().showUserRatingsScreen(window));
        quitButton.setOnAction(e -> System.exit(0));
    }

    private void setScene(Stage window, VBox layout) {
        mainScene = new Scene(layout, 500, 500);
        window.setScene(mainScene);
    }

}
