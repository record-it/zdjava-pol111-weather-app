package repository;

import mapper.WeatherMapper;
import model.CityWeather;
import model.Coordinate;
import model.CurrentWeather;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class JpaOpenWeatherRepository {
    static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("sda-zdjavapol111");
    private final EntityManager em = factory.createEntityManager();

    public void save(CurrentWeather entity){
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public CityWeather saveCityWeather(CurrentWeather entity, String city){
        em.getTransaction().begin();
        CityWeather cityWeather = WeatherMapper.mapTo(entity, city);
        em.persist(cityWeather);
        em.getTransaction().commit();
        return cityWeather;
    }

    public Optional<CurrentWeather> findById(long id){
        return Optional.ofNullable(em.find(CurrentWeather.class, id));
    }

    public List<CityWeather> findCityWeather(String city, LocalDate date){
        Query query = em.createQuery("select c from CityWeather c " +
                "where c.city = :city " +
                "and c.date = :date", CityWeather.class);
        query.setParameter("city", city);
        query.setParameter("date", date);
        return query.getResultList();
    }

    public List<CurrentWeather> findByCoordinates(Coordinate coordinate, long dt){
        final Query query = em.createQuery("select w from CurrentWeather w " +
                "where w.dt = :dt " +
                "and w.coord.lat = :lat " +
                "and w.coord.lon = :lon", CurrentWeather.class);
        query.setParameter("dt", dt);
        query.setParameter("lat", coordinate.getLat());
        query.setParameter("lon", coordinate.getLon());
        return query.getResultList();
    }
}
