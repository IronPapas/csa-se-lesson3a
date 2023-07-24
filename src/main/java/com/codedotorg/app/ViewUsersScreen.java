package com.codedotorg.app;

import com.codedotorg.User;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewUsersScreen {

    private ListView<User> listView;
    private Button backButton;
    private Scene scene;

    public ViewUsersScreen() {
        listView = new ListView<User>();
        backButton = new Button("Back");
    }
    
    public void showViewUsersScreen(Stage window) {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        createListView();
        setButtonAction(window);

        layout.getChildren().addAll(listView, backButton);

        setScene(window, layout);
    }

    private void createListView() {
        listView.getItems().clear();
        
        for (User user : MovieApp.getUsers()) {
            listView.getItems().add(user);
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
