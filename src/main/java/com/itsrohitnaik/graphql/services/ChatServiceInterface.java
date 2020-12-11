package com.itsrohitnaik.graphql.services;

import com.itsrohitnaik.graphql.model.Chat;

import java.util.List;

public interface ChatServiceInterface {
    Chat insertChat(Chat chat);
    void deleteChat(String id);
    List<Chat> getChatBetween(List<String> between);
}
