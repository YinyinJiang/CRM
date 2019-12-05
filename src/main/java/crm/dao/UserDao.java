package crm.dao;

import crm.model.User;

public interface UserDao {
    public void addUser(User user);
    public User getUserByUserId(int userId);
}
