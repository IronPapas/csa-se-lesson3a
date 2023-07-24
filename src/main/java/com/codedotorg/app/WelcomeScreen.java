package com.codedotorg.app;

import java.util.ArrayList;

import com.codedotorg.User;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WelcomeScreen {

    private VBox layout;
    private Label nameLabel;
    private TextField nameInput;
    private Button submitButton;
    private Scene scene;

    public WelcomeScreen() {
        layout = new VBox(10);
        nameLabel = new Label("Welcome! What's your name?");
        nameInput = new TextField();
        submitButton = new Button("Submit");
    }
    
    public void showWelcomeScreen(Stage window) {
        layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        setButtonAction(window);
        layout.getChildren().addAll(nameLabel, nameInput, submitButton);
        
        setAndShowScene(window);
    }

    private void setButtonAction(Stage window) {
        submitButton.setOnAction(e -> {
            if (!nameInput.getText().isEmpty()) {
                String username = nameInput.getText();
                setOrSwitchUser(username);
                MovieApp.getMainScreen().showMainScreen(window);
                nameInput.clear();
            }
        });
    }

    private void setAndShowScene(Stage window) {
        scene = new Scene(layout, 500, 500);
        window.setScene(scene);
        window.show();
    }

    private void setOrSwitchUser(String username) {
        boolean found = false;
        ArrayList<User> usersList = MovieApp.getUsers();

        for (int index = 0; index < usersList.size(); index++) {
            User currentUser = usersList.get(index);

            if (currentUser.getName().equals(username)) {
                MovieApp.setCurrentUser(currentUser);
                System.out.println("username found");
                found = true;
            }
        }

        if (!found) {
            User user = new User(username);
            MovieApp.addUser(user);
            MovieApp.setCurrentUser(user);
        }
    }

}
