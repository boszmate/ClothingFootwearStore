package com.mateusz.validator;

import com.mateusz.api.UserDao;
import com.mateusz.exception.UserShortLengthLoginException;
import com.mateusz.exception.UserShortLengthPasswordException;
import com.mateusz.model.User;

import java.io.IOException;

public class UserValidator {
    private final int MIN_LENGTH_LOGIN = 4;
    private final int MIN_LENGTH_PASSWORD = 6;
    private static UserValidator instance = null;

    private UserValidator() {}

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValidate(User user) throws UserShortLengthLoginException, UserShortLengthPasswordException {
        if (isLoginLengthNoEnough(user.getLogin())) {
            throw new UserShortLengthLoginException("Login is too short!");
        }

        if (isPasswordLengthNoEnough(user.getPassword())) {
            throw new UserShortLengthPasswordException("Password is too short!");
        }

        return true;
    }

    private boolean isLoginLengthNoEnough(String login) {
        return login.length() >= MIN_LENGTH_LOGIN;
    }

    private boolean isPasswordLengthNoEnough(String password) {
        return password.length() >= MIN_LENGTH_PASSWORD;
    }
}
