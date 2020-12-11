package com.itsrohitnaik.graphql.services;

import com.itsrohitnaik.graphql.model.User;

import java.util.List;

public interface UserServiceInterface {

    List<User> getChatHistory(String userId);
    User insertUser(User user);
}
