package studies.database;

import java.sql.Connection;

public interface Database {
    Connection getConnection();
    void closeConnection();
}
