package com.malimaquintino.javagraphql.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.malimaquintino.javagraphql.dto.UserInputDto;
import com.malimaquintino.javagraphql.model.User;
import com.malimaquintino.javagraphql.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private UserService userService;

    public List<User> users() {
        return userService.findUsers();
    }

    public User user(Long id) {
        return userService.findById(id);
    }

    public User saveUser(UserInputDto inputDto) {
        return userService.save(inputDto);
    }

}
