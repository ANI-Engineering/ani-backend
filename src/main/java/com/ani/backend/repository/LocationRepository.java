package com.ani.backend.repository;

import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LocationRepository {

    private static final String JDBC_URL = "jdbc:mysql://anidb.cz6sycku61rq.us-east-1.rds.amazonaws.com:3306/anidb";
    private static final String USERNAME = "aniuser2";
    private static final String PASSWORD = "pass@123ani";
    private static final String SELECT_LOCATIONS_QUERY = "SELECT location FROM building";

    public List<String> retrieveLocationsFromDatabase() {
        List<String> locations = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_LOCATIONS_QUERY)) {

            while (resultSet.next()) {
                String location = resultSet.getString("location");
                locations.add(location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locations;
    }
}
