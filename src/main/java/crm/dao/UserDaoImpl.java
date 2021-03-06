package crm.dao;

import crm.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            assert session != null;
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public User getUserByUserId(int userId) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            user = (User) session.get(User.class, userId);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
     }

}
