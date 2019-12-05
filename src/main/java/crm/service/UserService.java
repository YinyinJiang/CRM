package crm.service;

import crm.model.User;

public interface UserService {
    void addUser(User user);

    User getUserByUserId(int userId);
}
