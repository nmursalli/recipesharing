package com.example.recipesharingapp2;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class RecipesPage {
    private final VBox view;

    public RecipesPage(Stage stage) {
        view = new VBox(10);
        view.setPadding(new Insets(10));

        // UI Elements
        Text title = new Text("Recipes");
        ListView<String> recipesList = new ListView<>();

        // Fetch recipes from the database using RecipeDAO
        RecipeDAO recipeDAO = new RecipeDAO();
        List<String> recipes = recipeDAO.getAllRecipes(); // Fetch recipes from the database

        // Populate ListView with recipes from database
        recipesList.getItems().addAll(recipes);

        Button addRecipeButton = new Button("Add Recipe");
        Button viewRecipeButton = new Button("View Recipe");

        // Add Recipe Popup
        addRecipeButton.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Add Recipe");
            dialog.setHeaderText("Add a New Recipe");
            dialog.setContentText("Recipe Name:");

            dialog.showAndWait().ifPresent(recipe -> {
                // Add recipe to the list and the database
                recipeDAO.addRecipe(recipe, "Ingredients for " + recipe, "Instructions for " + recipe);
                recipesList.getItems().add(recipe); // Add recipe to the ListView
            });
        });

        // View Recipe Logic
        viewRecipeButton.setOnAction(e -> {
            String selectedRecipe = recipesList.getSelectionModel().getSelectedItem();
            if (selectedRecipe != null) {
                // Fetch the selected recipe details
                String recipeDetails = recipeDAO.getRecipeByName(selectedRecipe);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Recipe Details");
                alert.setHeaderText(selectedRecipe);
                alert.setContentText(recipeDetails); // Display details fetched from the database
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No Recipe Selected");
                alert.setHeaderText("Please select a recipe to view details.");
                alert.showAndWait();
            }
        });

        // Layout
        HBox buttonBar = new HBox(10, addRecipeButton, viewRecipeButton);
        view.getChildren().addAll(title, recipesList, buttonBar);
    }

    public VBox getView() {
        return view;
    }
}
