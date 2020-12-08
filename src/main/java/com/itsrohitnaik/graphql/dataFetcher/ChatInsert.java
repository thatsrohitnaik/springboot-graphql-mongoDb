package com.itsrohitnaik.graphql.dataFetcher;

import com.itsrohitnaik.graphql.model.Chat;
import com.itsrohitnaik.graphql.services.ChatService;
import com.itsrohitnaik.graphql.util.Util;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatInsert implements DataFetcher {
    @Autowired
    Util util;

    @Autowired
    private ChatService chatService;

    @Override
    public Object get(DataFetchingEnvironment environment) {
        Chat chat = util.getChat(environment);
        return chatService.insertChat(chat);
    }
}
