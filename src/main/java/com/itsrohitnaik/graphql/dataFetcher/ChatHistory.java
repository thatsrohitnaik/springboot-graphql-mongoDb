package com.itsrohitnaik.graphql.dataFetcher;

import com.itsrohitnaik.graphql.services.ChatService;
import com.itsrohitnaik.graphql.services.UserService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatHistory implements DataFetcher {

    @Autowired
    private UserService userService;

    @Override
    public Object get(DataFetchingEnvironment environment) {
        return userService.getChatHistory(environment.getArgument("userId"));
    }
}
