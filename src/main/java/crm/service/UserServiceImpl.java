package crm.service;

import crm.dao.UserDao;
import crm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    public User getUserByUserId(int userId) {
        return userDao.getUserByUserId(userId);
    }
}
