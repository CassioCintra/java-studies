package studies.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface DbUtils {
    static void closeStatement(Statement statement){}
    static void closeResultSet(ResultSet resultSet){}
}
