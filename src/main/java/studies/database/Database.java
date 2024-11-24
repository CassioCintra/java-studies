package studies.database;

import java.sql.Connection;

public interface Database {
    static Connection getConnection() {
        return null;
    }

    static void closeConnection() {

    }
}
