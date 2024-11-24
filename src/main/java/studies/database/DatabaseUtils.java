package studies.database;

import java.sql.ResultSet;
import java.sql.Statement;

public interface DatabaseUtils {
    static void closeStatement(Statement statement){}
    static void closeResultSet(ResultSet resultSet){}
}
