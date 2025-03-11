package org.example.model;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DB_NAME = "database.db";
    private static final String DB_PATH = Paths.get(System.getProperty("user.dir"), DB_NAME).toString();
    private static final String URL = "jdbc:sqlite:" + DB_PATH;

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Connected to SQLite: " + DB_PATH);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return conn;
    }

}
