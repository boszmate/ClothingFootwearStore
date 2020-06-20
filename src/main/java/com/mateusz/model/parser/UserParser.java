package com.mateusz.model.parser;

import com.mateusz.model.User;

public class UserParser {
    public static User stringToUser(String userString){
        String [] userInformation = userString.split(User.PRODUCT_SEPARATOR);

        int id = Integer.parseInt(userInformation[0]);
        String login = userInformation[1];
        String password = userInformation[2];

        return new User(id, login, password);
    }
}
