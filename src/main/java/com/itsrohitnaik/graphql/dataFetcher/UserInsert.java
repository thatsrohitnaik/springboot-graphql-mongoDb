package com.itsrohitnaik.graphql.dataFetcher;

import com.itsrohitnaik.graphql.services.UserService;
import com.itsrohitnaik.graphql.util.Mapper;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInsert implements DataFetcher {

    @Autowired
    private Mapper mapper;

    @Autowired
    private UserService userService;

    @Override
    public Object get(DataFetchingEnvironment environment) {
        return userService.insertUser(mapper.getUser(environment));
    }
}
