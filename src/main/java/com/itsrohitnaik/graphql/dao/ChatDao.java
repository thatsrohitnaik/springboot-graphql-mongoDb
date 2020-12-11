package com.itsrohitnaik.graphql.dao;

import com.itsrohitnaik.graphql.model.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChatDao implements ChatDaoInterface {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Chat insertChat(Chat chat) {
        mongoTemplate.insert(chat,"chat");
        return chat;
    }

    @Override
    public List<Chat> getAllChat(String senderId, String receiverId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("senderId").in(senderId, receiverId).and("receiverId").in(receiverId, senderId));
        List<Chat> chats = mongoTemplate.find(query, Chat.class, "chat");
        return chats;
    }

    @Override
    public void deleteChat(String id) {

    }


}
