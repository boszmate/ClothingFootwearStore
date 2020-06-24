package com.mateusz.validator;

import com.mateusz.api.UserDao;
import com.mateusz.api.UserService;
import com.mateusz.dao.UserDaoImpl;
import com.mateusz.exception.UserLoginAlreadyExistException;
import com.mateusz.exception.UserShortLengthLoginException;
import com.mateusz.exception.UserShortLengthPasswordException;
import com.mateusz.model.User;

import java.io.IOException;

public class UserValidator {
    private final int MIN_LENGTH_LOGIN = 4;
    private final int MIN_LENGTH_PASSWORD = 6;
    private static UserValidator instance = null;
    private UserDao userDao = null; //UserDaoImpl.getInstance();

    private UserValidator() {}

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValidate(User user) throws UserLoginAlreadyExistException, UserShortLengthLoginException, UserShortLengthPasswordException {
        if (!isLoginAlreadyExist(user.getLogin())) {
            throw new UserLoginAlreadyExistException("User with this login already exist!");
        }

        if (!isLoginLengthEnough(user.getLogin())) {
            throw new UserShortLengthLoginException("Login is too short!");
        }

        if (!isPasswordLengthEnough(user.getPassword())) {
            throw new UserShortLengthPasswordException("Password is too short!");
        }

        return true;
    }

    private boolean isLoginAlreadyExist(String login) {
        User user = null;
        try {
            user = userDao.getUserByLogin(login);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user != null;
    }

    private boolean isLoginLengthEnough(String login) {
        return login.length() >= MIN_LENGTH_LOGIN;
    }

    private boolean isPasswordLengthEnough(String password) {
        return password.length() >= MIN_LENGTH_PASSWORD;
    }
}
