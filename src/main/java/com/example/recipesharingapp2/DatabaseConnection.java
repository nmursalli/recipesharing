package com.example.recipesharingapp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:sqlitecloud://cozqwby7hk.sqlite.cloud:8860/chinook.sqlite?apikey=jg6KpRCmpsYB8chwKiNffQFo79xzYHJcz9jynbSKZS0";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "123456";

    // Method to establish and return a database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }
}
