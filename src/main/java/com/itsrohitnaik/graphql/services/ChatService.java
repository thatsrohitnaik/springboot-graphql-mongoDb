package com.itsrohitnaik.graphql.services;

import com.itsrohitnaik.graphql.dao.ChatDao;
import com.itsrohitnaik.graphql.model.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService implements ChatServiceInterface {

    @Autowired
    private ChatDao chatDao;

    @Override
    public Chat insertChat(Chat chat) {
        return  chatDao.insertChat(chat);
    }

    @Override
    public void deleteChat(String id) {

    }

    @Override
    public List<Chat> getAllChat(String senderId, String receiverId) {
        return chatDao.getAllChat(senderId,receiverId);
    }

}
