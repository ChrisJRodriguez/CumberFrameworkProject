package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DbUtils {

    public static List<Map<String, String>> fetchData(String query) {
        // This method should connect to the database, execute the query,
        // and return the results as a list of maps where each map represents a row.
        // The keys in the map are column names and values are the corresponding data.
        // Implementation details would depend on the specific database and JDBC setup.
        String dbURL = ConfigReader.read("dbURL");
        String userName = ConfigReader.read("dbUserName");
        String password = ConfigReader.read("dbPassword");
        List<Map<String, String>> tableData = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(dbURL, userName, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();


            while (resultSet.next()) {
                // Create a map to hold the row data
                Map<String, String> row = new LinkedHashMap<>();

                // Loop through each column in the result set
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    String columnName = metaData.getColumnLabel(i);
                    String value = resultSet.getString(i);
                    row.put(columnName, value);
                }
                tableData.add(row);
                // Here you would add the row to a list that you return
                // For example: results.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableData;
    }
}
