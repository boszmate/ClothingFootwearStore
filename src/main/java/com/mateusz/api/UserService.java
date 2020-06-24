package com.mateusz.api;

import com.mateusz.model.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    boolean addUser(User user);

    void removeUserById(int userId) throws IOException;

    List<User> getAllUsers() throws IOException;
    User getUserById(int userId) throws IOException;
    User getUserByLogin(String login) throws IOException;

    boolean isCorrectLoginAndPassword(String login, String password);
}
