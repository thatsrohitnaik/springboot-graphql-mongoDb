package com.itsrohitnaik.graphql.dao;

import com.itsrohitnaik.graphql.model.Chat;

import java.util.List;

public interface ChatDaoInterface {
    Chat insertChat(Chat chat);
    List<Chat> getAllChat(String senderId, String receiverId);
    List<Chat> getLastChats(String senderId);
    void deleteChat(String id);
}
