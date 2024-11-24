package studies.database.implementation;

import studies.config.ConfigLoader;
import studies.database.Database;
import studies.database.exception.DatabaseException;

import java.sql.*;
import java.util.Map;

public class DatabaseImp implements Database {
    private Connection connection = null;

    @Override
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Map<String, Object> properties = ConfigLoader.loadConfig("application.yml");
                Map<String, Object> database = (Map<String, Object>) properties.get("database");
                String url = (String) database.get("url");
                String username = (String) database.get("username");
                String password = (String) database.get("password");
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error connecting to database" + e);
        } catch (ClassCastException | NullPointerException o) {
            throw new DatabaseException("Invalid configuration in application.yml: " + o.getMessage());
        }
        return connection;
    }

    @Override
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DatabaseException(e.getMessage());
            }
        }
    }
}
