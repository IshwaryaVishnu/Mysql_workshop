package se.lexicon;

import java.sql.*;

public class CityDaoJDBC {

    public static void main(String[] args) {
        // define database connection
        try {
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","1246");
            Statement statement = connection.createStatement();
            String selectAllCity ="select * from city";

            // executeQuery() is used to execute SELECT query
            ResultSet resultSet = statement.executeQuery(selectAllCity);
            while(resultSet.next()){
                System.out.println();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String countryCode = resultSet.getString("countryCode");
                String district = resultSet.getString("district");
                int population = resultSet.getInt("population");
                CityDaoJDBC city = new CityDaoJDBC(id,name,countryCode,district,population);


                String firstName = resultSet.getString("p.first_name");
                String lastName = resultSet.getString("p.last_name");
                Date regDate = resultSet.getDate("p.reg_date");
                boolean active = resultSet.getBoolean("p._active");


            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
}
