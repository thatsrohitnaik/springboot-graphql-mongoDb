package com.itsrohitnaik.graphql.services;

import com.itsrohitnaik.graphql.dataFetcher.ChatBetween;
import com.itsrohitnaik.graphql.dataFetcher.ChatHistory;
import com.itsrohitnaik.graphql.dataFetcher.ChatInsert;
import com.itsrohitnaik.graphql.dataFetcher.UserInsert;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class GraphqlService {

    @Value("classpath:users.graphql")
    Resource resource;

    @Autowired
    private ChatInsert chatInsert;

    @Autowired
    private ChatBetween chatBetween;

    @Autowired
    private ChatHistory chatHistory;

    @Autowired
    private UserInsert userInsert;

    private GraphQL graphQL;

    @PostConstruct
    private void GraphqlService() throws IOException {
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {

        Map<String, DataFetcher> mapOfDatafetchers  = new HashMap<>();

        mapOfDatafetchers.put("chatInsert", chatInsert);
        mapOfDatafetchers.put("chatBetween", chatBetween);
        mapOfDatafetchers.put("chatHistory", chatHistory);
        mapOfDatafetchers.put("userInsert", userInsert);

        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetchers(mapOfDatafetchers)
                )
                .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }
}