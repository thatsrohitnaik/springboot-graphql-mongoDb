package com.itsrohitnaik.graphql.dataFetcher;

import com.itsrohitnaik.graphql.services.ChatService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatGet implements DataFetcher {
    @Autowired
    private ChatService chatService;

    @Override
    public Object get(DataFetchingEnvironment environment) {
        return chatService.getChatBetween(environment.getArgument("between"));
    }
}
