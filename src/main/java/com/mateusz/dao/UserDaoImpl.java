package com.mateusz.dao;

import com.mateusz.api.UserDao;
import com.mateusz.model.User;
import com.mateusz.model.parser.UserParser;
import com.mateusz.utils.FileUtils;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final static UserDao instance = new UserDaoImpl();

    private Connection connection;
    private final String databaseName = "management";
    private final String tableName = "users";
    private final String user = "mateusz";
    private final String password = "123";

    private UserDaoImpl() {
        init();
    }

    public static UserDao getInstance() {
        return UserDaoImpl.instance;
    }

    private void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?useSSL=false", user, password);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void saveUser(User user) {
        PreparedStatement statement;
        try {
            String query = "insert into " + tableName + " (login, password) values (?,?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(int userId) {
        PreparedStatement statement;

        try {
            String query = "delete from " + tableName + " where id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, userId);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserByLogin(String login) {
        PreparedStatement statement;

        try {
            String query = " delete from " + tableName + " where login = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, login);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new LinkedList<User>();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            String query = "select * from " + tableName;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");

                User user = new User(id, login, password);
                users.add(user);
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public void updateUser(User user) {
        PreparedStatement statement;

        try {
            String query = "update " + tableName + " set login = ?, password = ? where id = ?";
            statement = connection.prepareStatement(query);

            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getId());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
