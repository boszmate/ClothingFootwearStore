package com.mateusz.facade;

import com.mateusz.api.UserRegisterLoginFacade;
import com.mateusz.api.UserService;
import com.mateusz.exception.UserLoginAlreadyExistException;
import com.mateusz.exception.UserShortLengthLoginException;
import com.mateusz.exception.UserShortLengthPasswordException;
import com.mateusz.model.User;
import com.mateusz.service.UserServiceImpl;

public class UserRegisterLoginFacadeImpl implements UserRegisterLoginFacade {
    private static UserRegisterLoginFacadeImpl instance = null;
    private UserService userService = UserServiceImpl.getInstance();

    private UserRegisterLoginFacadeImpl() {}

    public static UserRegisterLoginFacadeImpl getInstance() {
        if (instance == null) {
            instance = new UserRegisterLoginFacadeImpl();
        }

        return instance;
    }

    public String registerUser(User user) {
        try {
            userService.addUser(user);
            return "Register successfully";
        } catch (UserLoginAlreadyExistException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (UserShortLengthLoginException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (UserShortLengthPasswordException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public boolean loginUser(String login, String password) {
        return userService.isCorrectLoginAndPassword(login, password);
    }
}
