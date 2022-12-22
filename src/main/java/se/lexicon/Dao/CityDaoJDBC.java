package se.lexicon.Dao;

import se.lexicon.MysqlConnection;
import se.lexicon.exception.DBConnectionException;
import se.lexicon.model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDaoJDBC implements  CityDao{

    @Override
    public City findById(int id) {

        City city = new City();

        String query = "select * from City where id = ?";

        try (
                Connection connection = MysqlConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
            )
        {

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, "t" + "%");

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                city = new City(rs.getInt("id"),
                        rs.getString("Name"),
                        rs.getString("CountryCode"),
                        rs.getString("District"),
                        rs.getDouble("Population"));
                }

        } catch ( SQLException | DBConnectionException e) {
            System.out.println(e.getMessage());
        }

        return city;
    }

    @Override
    public List<City> findByCode(String code) {

        List<City> cities = new ArrayList<>();

        String sql = "SELECT * FROM cities WHERE CountryCode = ?";

        try (
                Connection connection = MysqlConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
             preparedStatement.setString(1, code);

            ResultSet rs = preparedStatement.executeQuery();

            // Iterate through the result set and create City objects for each row
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("Name");
                String district = rs.getString("District");
                String countryCode = rs.getString("CountryCode");
                Double population = rs.getDouble("Population");

                City city = new City(id, name, district, countryCode, population);
                cities.add(city);
            }
        } catch (SQLException | DBConnectionException e) {
            e.printStackTrace();
        }

        return cities;
    }

    @Override
    public List<City> findByName(String name) {
        return null;
    }

    @Override
    public List<City> findAll() {
        return null;
    }

    @Override
    public City add(City city) {

        String sql = "insert into city (id, name, countrycode, district, population) values(?, ?, ?, ?, ?, ?)";

        try (
                Connection connection = MysqlConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        )
        {
            preparedStatement.setInt(1, city.getId());
            preparedStatement.setString(2, city.getName());
            preparedStatement.setString(3,city.getDistrict());
            preparedStatement.setString(4,city.getCountryCode());
            preparedStatement.setDouble(5, city.getPopulation());

            ResultSet rs = preparedStatement.executeQuery();

        } catch (SQLException | DBConnectionException e) {
            throw new RuntimeException(e);
        }

        return city;
    }

    @Override
    public City update(City city) {
        return null;
    }

    @Override
    public int delete(City city) {
        return 0;
    }
}
