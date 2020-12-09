package com.itsrohitnaik.graphql.dataFetcher;

import com.itsrohitnaik.graphql.dao.ChatDao;
import com.itsrohitnaik.graphql.services.ChatService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatGetLast implements DataFetcher {

    @Autowired
    private ChatService chatService;

    @Override
    public Object get(DataFetchingEnvironment environment) {
        return chatService.getLastChats(environment.getArgument("senderId"));
    }
}
