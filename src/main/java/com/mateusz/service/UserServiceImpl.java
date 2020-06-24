package com.mateusz.service;

import com.mateusz.api.UserDao;
import com.mateusz.api.UserService;
import com.mateusz.dao.UserDaoImpl;
import com.mateusz.exception.UserLoginAlreadyExistException;
import com.mateusz.exception.UserShortLengthLoginException;
import com.mateusz.exception.UserShortLengthPasswordException;
import com.mateusz.model.User;
import com.mateusz.validator.UserValidator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = null;
    private UserDao userDao = UserDaoImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

    private UserServiceImpl() {}

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public void addUser(User user) throws IOException, UserLoginAlreadyExistException, UserShortLengthLoginException, UserShortLengthPasswordException {
        if (userValidator.isValidate(user)) {
            userDao.saveUser(user);
        }
    }

    public void removeUserById(int userId) throws IOException {
        userDao.removeUserById(userId);
    }

    public List<User> getAllUsers() throws IOException {
        return userDao.getAllUsers();
    }
}
