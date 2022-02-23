package repository;

import model.Coordinate;
import model.CurrentWeather;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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

    public void saveCityWeather(CurrentWeather entity, String city){

    }

    public Optional<CurrentWeather> findById(long id){
        return Optional.ofNullable(em.find(CurrentWeather.class, id));
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
