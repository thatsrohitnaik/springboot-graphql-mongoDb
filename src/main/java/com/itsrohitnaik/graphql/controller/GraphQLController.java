package com.itsrohitnaik.graphql.controller;

import com.itsrohitnaik.graphql.services.GraphqlService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GraphQLController {

    @Autowired
    GraphqlService graphqlService;

    @PostMapping("/graphql")
    public ResponseEntity<Object> graphQL(@RequestBody String query) {
        ExecutionResult execute = graphqlService.getGraphQL().execute(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}
