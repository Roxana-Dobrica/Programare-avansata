package lab8homework;

import java.sql.*;

/**
 *
 * @author Roxana Dobrica
 */
public class Database {

    private static final String URL
            = "jdbc:mysql://localhost:3306/music";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static Connection connection = null;

    private Database() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }

    public static void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
