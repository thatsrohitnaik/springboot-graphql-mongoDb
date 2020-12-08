package com.itsrohitnaik.graphql.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    public MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://chatUser:yv687sBTyGRY5Gu@cluster0.a6bwk.mongodb.net/test?retryWrites=true&w=majority");
    }

    public @Bean MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "test");
    }

}