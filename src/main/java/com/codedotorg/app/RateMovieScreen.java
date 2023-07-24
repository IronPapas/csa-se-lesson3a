package com.codedotorg.app;

import java.util.Optional;

import com.codedotorg.Movie;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RateMovieScreen {

    private ComboBox<Movie> movieDropdown;
    private Button backButton;
    private Scene scene;

    public RateMovieScreen() {
        movieDropdown = new ComboBox<Movie>();
        backButton = new Button("Back");
    }
    
    public void showRateMovieScene(Stage window) {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        createMovieDropdown();

        HBox ratingButtons = new HBox(10);
        createRatingButtons(window, ratingButtons);

        setButtonAction(window);

        layout.getChildren().addAll(movieDropdown, ratingButtons, backButton);

        setScene(window, layout);
    }

    private void createMovieDropdown() {
        for (Movie movie : MovieApp.getMovies()) {
            movieDropdown.getItems().add(movie);
        }
    }

    private void createRatingButtons(Stage window, HBox ratingButtons) {
        for (int index = 1; index <= 5; index++) {
            Button button = new Button(String.valueOf(index));

            button.setOnAction(e -> {
                // TO DO: Add rating to selected movie
                Movie selectedMovie = movieDropdown.getSelectionModel().getSelectedItem();

                if (selectedMovie != null) {
                    selectedMovie.addRating(MovieApp.getCurrentUser(), Integer.parseInt(button.getText()));
                    MovieApp.getCurrentUser().addRating(selectedMovie, Integer.parseInt(button.getText()));
                    movieDropdown.getSelectionModel().clearSelection();
                }
                else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("No movie selected!");
                    alert.setHeaderText("Please select a movie to rate.");
                    alert.showAndWait();
                }

                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Rate another movie");
                alert.setHeaderText("Do you want to rate another movie?");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.OK) {
                    showRateMovieScene(window);
                }
                else {
                    MovieApp.getMainScreen().showMainScreen(window);
                }
            });

            ratingButtons.getChildren().add(button);
        }
    }

    private void setButtonAction(Stage window) {
        backButton.setOnAction(e -> MovieApp.getMainScreen().showMainScreen(window));
    }

    private void setScene(Stage window, VBox layout) {
        scene = new Scene(layout, 500, 500);
        window.setScene(scene);
    }

}
