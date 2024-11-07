package LAB2.Dao;



import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

import LAB2.Utils.XJPA;
import LAB2.entity.Userr;





public class UserDAOImpl implements UserDAO {
    EntityManager em = XJPA.getEntityManager();

    @Override
    public List<Userr> findAll() {
        String jpql = "SELECT o FROM Userr o";
        TypedQuery<Userr> query = em.createQuery(jpql, Userr.class);
        return query.getResultList();
    }

    @Override
    public Userr findById(String id) {
        return em.find(Userr.class, id);
    }

    @Override
    public void create(Userr entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Userr entity) {
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void deleteById(String id) {
        Userr entity = em.find(Userr.class, id);
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

	
}
