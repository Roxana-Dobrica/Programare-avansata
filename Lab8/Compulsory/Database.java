package com.mycompany.lab8compulsory;

import java.sql.*;

/**
 *
 * @author Roxana Dobrica
 */
public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/lab8";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;

    private Database() {
        if (connection != null) {
            throw new IllegalStateException("Already initialized.");
        }

    }

    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
