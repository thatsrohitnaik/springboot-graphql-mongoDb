package com.itsrohitnaik.graphql.services;

import com.itsrohitnaik.graphql.dao.UserDao;
import com.itsrohitnaik.graphql.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getChatHistory(String userId) {
        return userDao.getChatHistory(userId);
    }

    @Override
    public User insertUser(User user) {
        return userDao.insertUser(user);
    }
}
