package com.mateusz.api;

import com.mateusz.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void removeUserById(int userId);
    List<User> getAllUsers();
}
