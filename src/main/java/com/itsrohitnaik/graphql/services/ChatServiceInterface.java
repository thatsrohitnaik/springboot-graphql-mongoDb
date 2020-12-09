package com.itsrohitnaik.graphql.services;

import com.itsrohitnaik.graphql.model.Chat;

import java.util.List;

public interface ChatServiceInterface {
    Chat insertChat(Chat chat);
    void deleteChat(String id);
    List<Chat> getAllChat(String senderId, String receiverId);
    List<Chat> getLastChats(String senderId);

}
