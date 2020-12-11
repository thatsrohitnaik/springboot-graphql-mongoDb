package com.itsrohitnaik.graphql.util;

import com.itsrohitnaik.graphql.model.Chat;
import com.itsrohitnaik.graphql.model.User;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Chat getChat(DataFetchingEnvironment env){

        Chat chat = new Chat();
        chat.setReceiverId(env.getArgument("receiverId"));
        chat.setSenderId(env.getArgument("senderId"));
        chat.setId(env.getArgument("id"));
        chat.setMessage(env.getArgument("message"));
        chat.setTime(env.getArgument("time"));
        System.out.println(chat);

        return chat;
    }

    public User getUser(DataFetchingEnvironment env) {

        User user = new User();
        user.setUserId(env.getArgument("userId"));
        user.setUserImagePath(env.getArgument("userImagePath"));
        user.setUserName(env.getArgument("userName"));
        user.setUserStatus(env.getArgument("userStatus"));

        return user;
    }
}
