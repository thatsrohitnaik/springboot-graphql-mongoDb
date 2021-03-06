package com.itsrohitnaik.graphql.dataFetcher;

import com.itsrohitnaik.graphql.services.ChatService;
import com.itsrohitnaik.graphql.util.Mapper;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatInsert implements DataFetcher {

    @Autowired
    Mapper mapper;

    @Autowired
    private ChatService chatService;

    @Override
    public Object get(DataFetchingEnvironment environment) {
        return chatService.insertChat(mapper.getChat(environment));
    }
}
