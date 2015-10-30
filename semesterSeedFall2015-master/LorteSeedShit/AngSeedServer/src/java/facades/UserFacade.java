package facades;

import entity.User;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import security.PasswordHash;

public class UserFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("AngSeedServerPU");
    EntityManager em = emf.createEntityManager();

    public UserFacade() {
    }

    public void createUser(User user) throws NoSuchAlgorithmException, InvalidKeySpecException {
        User hashedUser = new User();
        hashedUser.setUserName(user.getUserName());
        hashedUser.setPassword(PasswordHash.createHash(user.getPassword()));

        em.getTransaction().begin();
        em.persist(hashedUser);
        em.getTransaction().commit();
    }

    public User getUserByUserId(String id) {
        return em.find(User.class, id);
    }

    /*
     Return the Roles if users could be authenticated, otherwise null
     */
    public List<String> authenticateUser(String userName, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        User hashedUser = new User();
        hashedUser.setPassword(PasswordHash.createHash(password));

        Query query = em.createQuery("SELECT u FROM User u WHERE u.userName=:username").setParameter("username", userName);
        User user = (User) query.getSingleResult();

        return user != null && user.getPassword().equals(hashedUser.getPassword()) ? user.getRoles() : null;
    }

}
