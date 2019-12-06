package crm.dao;

import crm.model.User;

public interface UserDao {
    void addUser(User user);
    User getUserByUserId(int userId);
}
