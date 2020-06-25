package com.mateusz.validator;

import com.mateusz.exception.UserShortLengthLoginException;
import com.mateusz.exception.UserShortLengthPasswordException;
import com.mateusz.model.User;

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
        if (isLoginLengthNotEnough(user.getLogin())) {
            throw new UserShortLengthLoginException("Login is too short!");
        }

        if (isPasswordLengthNotEnough(user.getPassword())) {
            throw new UserShortLengthPasswordException("Password is too short!");
        }

        return true;
    }

    private boolean isLoginLengthNotEnough(String login) {
        return login.length() <= MIN_LENGTH_LOGIN;
    }

    private boolean isPasswordLengthNotEnough(String password) {
        return password.length() <= MIN_LENGTH_PASSWORD;
    }
}
