package com.malimaquintino.javagraphql.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.malimaquintino.javagraphql.dto.RoleInputDto;
import com.malimaquintino.javagraphql.model.Role;
import com.malimaquintino.javagraphql.services.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private RoleService roleService;

    public List<Role> roles() {
        return roleService.findRoles();
    }

    public Role role(Long id) {
        return roleService.findById(id);
    }

    public Role saveRole(RoleInputDto roleInputDto) {
        return roleService.save(roleInputDto);
    }

}
