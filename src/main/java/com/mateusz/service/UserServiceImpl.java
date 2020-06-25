package com.mateusz.service;

import com.mateusz.api.UserDao;
import com.mateusz.api.UserService;
import com.mateusz.dao.UserDaoImpl;
import com.mateusz.exception.UserLoginAlreadyExistException;
import com.mateusz.model.User;
import com.mateusz.validator.UserValidator;

import java.io.IOException;
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

    public boolean addUser(User user) {
        try {
            if (isLoginAlreadyExist(user.getLogin())) {
                throw new UserLoginAlreadyExistException();
            }

            if (userValidator.isValidate(user)) {
                userDao.saveUser(user);
                return true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private boolean isLoginAlreadyExist(String login) {
        User user = getUserByLogin(login);

        return user != null;
    }

    public void removeUserById(int userId) throws IOException {
        userDao.removeUserById(userId);
    }

    public List<User> getAllUsers() throws IOException {
        return userDao.getAllUsers();
    }

    public User getUserById(int userId) {
        List<User> users = null;

        try {
            users = getAllUsers();
            for (User user : users) {
                if (user.getId() == userId) {
                    return user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public User getUserByLogin(String login){
        List<User> users = null;

        try {
            users = getAllUsers();
            for (User user : users) {
                if (user.getLogin().equals(login)) {
                    return user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean isCorrectLoginAndPassword(String login, String password) {
        User foundUser = getUserByLogin(login);

        if (foundUser == null) {
            return false;
        }

        boolean isCorrectLogin = foundUser.getLogin().equals(login);
        boolean isCorrectPassword = foundUser.getPassword().equals(password);

        return isCorrectLogin && isCorrectPassword;
    }
}
