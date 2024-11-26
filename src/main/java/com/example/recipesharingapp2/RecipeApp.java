package com.example.recipesharingapp2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RecipeApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        LoginSignupPage loginSignupPage = new LoginSignupPage(primaryStage);

        primaryStage.setTitle("Recipe Sharing App");
        primaryStage.setScene(new Scene(loginSignupPage.getView(), 400, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
