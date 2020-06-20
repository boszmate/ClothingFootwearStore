package com.mateusz.service;

import com.mateusz.api.UserService;
import com.mateusz.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    List<User> users;

    public UserServiceImpl() {
        this.users = new ArrayList<User>();
    }

    public UserServiceImpl(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUserById(int userId) {
        for(User user:users) {
            if(user.getId() == userId){
                users.remove(user);
                break;
            }
        }
    }

    public List<User> getAllUsers(){
        return users;
    }
}
