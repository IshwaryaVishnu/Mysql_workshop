package se.lexicon;

import se.lexicon.exception.DBConnectionException;

import java.sql.*;

public class JDBC {

    public static void main(String[] args) {
        String query = "select * from city";

        try (
                Connection connection = MysqlConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {


            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("countryCode"));
                System.out.println(resultSet.getString("district"));
                System.out.println(resultSet.getDouble("population"));
                System.out.println("-------------");
            }

        } catch (DBConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


