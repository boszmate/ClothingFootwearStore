/*
package com.mateusz.service;

import com.mateusz.api.UserService;
import com.mateusz.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {
    @Test
    public void testAddUser() {
        List<User> users = new ArrayList<User>();
        User user = new User(1, "test", "test");
        users.add(user);

        UserServiceImpl userService = new UserServiceImpl();
        userService.addUser(user);
        List<User> usersForTest = userService.getAllUsers();

        Assert.assertEquals(users, usersForTest);
    }

    @Test
    public void testRemoveUserById() {
        List<User> users = new ArrayList<User>();
        User user1 = new User(1, "user1", "user1");
        User user2 = new User(2, "user2", "user2");
        users.add(user1);
        users.add(user2);

        UserServiceImpl userService = new UserServiceImpl(users);
        users.remove(1);
        userService.removeUserById(1);
        List<User> usersForTest = userService.getAllUsers();

        Assert.assertEquals(users, usersForTest);
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = new ArrayList<User>();
        users.add(new User(1, "admin", "admin"));
        users.add(new User(2, "ken", "ken123"));

        UserServiceImpl userService = new UserServiceImpl(users);
        List<User> usersForTest = userService.getAllUsers();

        Assert.assertEquals(users, usersForTest);
    }
}
*/
