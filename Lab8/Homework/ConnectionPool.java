package lab8homework;

import java.sql.*;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Roxana Dobrica
 */
public class ConnectionPool {

    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/music");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        dataSource.setMaxTotal(100);
    }

    public static Connection getConnection() throws SQLException {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
