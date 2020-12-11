package com.itsrohitnaik.graphql.dao;

import com.itsrohitnaik.graphql.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao implements UserDaoInterface{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<User> getChatHistory(String senderId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("senderId").is(senderId));
        List<String> receiverIds = mongoTemplate.findDistinct(query, "receiverId","chat", String.class);
        List<User> users = new ArrayList<>();
        receiverIds.forEach(r -> {
            System.out.println(r);
            Query query1 = new Query();
            query1.addCriteria(Criteria.where("userId").is(r));
            users.add(this.mongoTemplate.findOne(query1, User.class, "user"));
        });
        return users;
    }

    @Override
    public User insertUser(User user) {
        return mongoTemplate.insert(user,"user");
    }


}
