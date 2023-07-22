package com.example.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
       public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/mydatabase";
        String username = "myuser";
        String password = "secret";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Perform database operations here

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
