package com.example.recipesharingapp2;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class LoginSignupPage {
    private final GridPane view;

    public LoginSignupPage(Stage stage) {
        view = new GridPane();
        view.setPadding(new Insets(10));
        view.setHgap(10);
        view.setVgap(10);

        // UI Elements
        Text title = new Text("Welcome to Recipe Sharing App");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        Button loginButton = new Button("Login");
        Button signupButton = new Button("Sign Up");

        // Event Handlers (Placeholders for backend logic)
        loginButton.setOnAction(e -> {
            // Validate user and navigate to Recipes Page
            stage.setScene(new Scene(new RecipesPage(stage).getView(), 600, 400));
        });

        signupButton.setOnAction(e -> {
            // Register user and navigate to Recipes Page
            stage.setScene(new Scene(new RecipesPage(stage).getView(), 600, 400));
        });

        // Layout
        view.add(title, 0, 0, 2, 1);
        view.add(usernameField, 0, 1, 2, 1);
        view.add(passwordField, 0, 2, 2, 1);
        view.add(loginButton, 0, 3);
        view.add(signupButton, 1, 3);
    }

    public GridPane getView() {
        return view;
    }
}
