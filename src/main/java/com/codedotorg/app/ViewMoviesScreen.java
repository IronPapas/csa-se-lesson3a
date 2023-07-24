package com.codedotorg.app;

import com.codedotorg.Movie;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewMoviesScreen {

    private ListView<Movie> listView;
    private Button backButton;
    private Scene scene;

    public ViewMoviesScreen() {
        listView = new ListView<Movie>();
        backButton = new Button("Back");
    }

    public void showViewMoviesScreen(Stage window) {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        createListView();
        setButtonAction(window);

        layout.getChildren().addAll(listView, backButton);

        setScene(window, layout);
    }

    private void createListView() {
        for (Movie movie : MovieApp.getMovies()) {
            listView.getItems().add(movie);
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
