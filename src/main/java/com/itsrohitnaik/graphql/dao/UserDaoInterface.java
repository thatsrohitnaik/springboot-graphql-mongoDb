package com.itsrohitnaik.graphql.dao;

import com.itsrohitnaik.graphql.model.User;
import java.util.List;

public interface UserDaoInterface {
    List<User> getChatHistory(String senderId);
    User insertUser(User user);

}
