package com.malimaquintino.javagraphql.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.malimaquintino.javagraphql.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserGraphQl implements GraphQLQueryResolver {

//    public List<User> users() {
//        return List.of();
//    }

    public String hello(){
        return "hello";
    }
}
