package com.example.recipesharingapp2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO {

    // Use DatabaseConnection to get the connection
    public Connection connect() throws SQLException {
        return DatabaseConnection.getConnection();
    }

    // Add a recipe to the database
    public void addRecipe(String recipeName, String ingredients, String instructions) {
        String query = "INSERT INTO recipes (name, ingredients, instructions) VALUES (?, ?, ?)";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, recipeName);
            preparedStatement.setString(2, ingredients);
            preparedStatement.setString(3, instructions);
            preparedStatement.executeUpdate();
            System.out.println("Recipe added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all recipes from the database
    public List<String> getAllRecipes() {
        List<String> recipes = new ArrayList<>();
        String query = "SELECT name FROM recipes";

        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                recipes.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipes;
    }

    // Get a recipe by name
    public String getRecipeByName(String recipeName) {
        String query = "SELECT * FROM recipes WHERE name = ?";
        String result = null;

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, recipeName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                result = "Name: " + resultSet.getString("name") + "\n" +
                        "Ingredients: " + resultSet.getString("ingredients") + "\n" +
                        "Instructions: " + resultSet.getString("instructions");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
