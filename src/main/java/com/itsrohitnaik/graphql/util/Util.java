package com.itsrohitnaik.graphql.util;

import com.itsrohitnaik.graphql.model.Chat;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

@Component
public class Util {

    public Chat getChat(DataFetchingEnvironment env){

        Chat chat = new Chat();
        chat.setReceiverId(env.getArgument("receiverId"));
        chat.setSenderName(env.getArgument("senderId"));
        chat.setId(env.getArgument("id"));
        chat.setMessage(env.getArgument("message"));
        System.out.println(chat);

        return chat;
    }
}
