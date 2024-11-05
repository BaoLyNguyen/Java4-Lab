package LAB1;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import jakarta.persistence.TypedQuery;

public class UserManager {

    private EntityManager em;

    public UserManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
        this.em = emf.createEntityManager();
    }

    public void findAll() {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
//        TypedQuery<User> query = (TypedQuery<User>) em.createNativeQuery(jpql, User.class);
        		
//        		em.createQuery(jpql,User.class);
        
        
        List<User> users = query.getResultList();

        for (User user : users) {
            String fullname = user.getFullname();
            Boolean admin = user.getAdmin();
            System.out.println("Fullname: " + fullname + ", Admin: " + admin);
        }
    }

    public void findById() {
        User user = em.find(User.class, "USR0001");
        String fullname = user.getFullname();
        Boolean admin = user.getAdmin();
        System.out.println("Fullname: " + fullname + ", Admin: " + admin);
    }

    public void create() {
        User user = new User("USR0002", "123456", "Test User", "test@fpt.edu.vn", false);

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public void update() {
        User user = em.find(User.class, "USR0001");
        user.setFullname("Updated User");
        user.setEmail("updated@example.com");

        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public void deleteById() {
        User user = em.find(User.class, "USR0001");

        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }
    
    public void findByEmail() {
        String jpql = "SELECT u FROM User u WHERE u.email LIKE :search AND u.admin=?1";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("search", "%@fpt.edu.vn");
        query.setParameter(1, false);
        
        List<User> users = query.getResultList();

        for (User user : users) {
            String fullname = user.getFullname();
            Boolean admin = user.getAdmin();
            System.out.println("Fullname: " + fullname + ", Admin: " + admin);
        }
    }
    
    public void findAllPhanTrang() {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
//        TypedQuery<User> query = (TypedQuery<User>) em.createNativeQuery(jpql, User.class);
        		
//        		em.createQuery(jpql,User.class);
        query.setFirstResult(2*5);
        query.setMaxResults(5);
        
        List<User> users = query.getResultList();
        
        
        for (User user : users) {
            String fullname = user.getFullname();
            Boolean admin = user.getAdmin();
            System.out.println("Fullname: " + fullname + ", Admin: " + admin);
        }
    }
}