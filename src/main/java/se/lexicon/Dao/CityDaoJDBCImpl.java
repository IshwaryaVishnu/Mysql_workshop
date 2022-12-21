package se.lexicon.Dao;

import se.lexicon.model.City;

import java.util.ArrayList;
import java.util.List;

public class CityDaoJDBCImpl implements CityDao {

    private List<City> cityList;

    public CityDaoJDBCImpl() {
        this.cityList = new ArrayList<>();
    }

    @Override
    public City findById(Integer id) {
        if (id == null) throw new IllegalArgumentException("id was null");
        for (City city : cityList)
            if (city.getId().equals(id)) return city;

        return null;
    }



    @Override
    public List<City> findByCode(String code) {
        return new ArrayList<>(cityList);
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
        return null;
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
