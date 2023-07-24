package com.codedotorg.app;

import com.codedotorg.Rating;
import com.codedotorg.User;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserRatingsScreen {

    private Label userLabel;
    private ListView<String> listView;
    private Button backButton;
    private Scene scene;

    public UserRatingsScreen() {
        userLabel = new Label();
        listView = new ListView<String>();
        backButton = new Button("Back");
    }
    
    public void showUserRatingsScreen(Stage window) {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        
        setButtonAction(window);

        layout.getChildren().addAll(userLabel, listView, backButton);

        setScene(window, layout);
    }

    private void setButtonAction(Stage window) {
        backButton.setOnAction(e -> MovieApp.getMainScreen().showMainScreen(window));
    }

    private void setScene(Stage window, VBox layout) {
        scene = new Scene(layout, 500, 500);
        window.setScene(scene);
    }

}
