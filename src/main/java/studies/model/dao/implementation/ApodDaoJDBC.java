package studies.model.dao.implementation;

import studies.model.dao.ApodDAO;
import studies.model.entity.ApodEntity;

import java.sql.*;

public class ApodDaoJDBC implements ApodDAO {
    private final Connection connection;

    public ApodDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(ApodEntity entity) {
        String sql = "INSERT INTO apod (date, explanation, media_type, service_version, title, url) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entity.getDate());
            statement.setString(2, entity.getExplanation());
            statement.setString(3, entity.getMediaType());
            statement.setString(4, entity.getServiceVersion());
            statement.setString(5, entity.getTitle());
            statement.setString(6, entity.getUrl());

            int rows = statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (rows > 0) {
                    if (generatedKeys.next()) {
                        entity.setId(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
