package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaOpenWeatherRepository {
    static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("sda-zdjavapol111");
    private final EntityManager em = factory.createEntityManager();

    public void save(){
        em.getTransaction().begin();
        
        em.getTransaction().commit();
    }
}
