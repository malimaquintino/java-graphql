package com.malimaquintino.javagraphql.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.malimaquintino.javagraphql.dto.GroupInputDto;
import com.malimaquintino.javagraphql.model.Group;
import com.malimaquintino.javagraphql.services.group.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private GroupService groupService;

    public List<Group> groups() {
        return groupService.findGroups();
    }

    public Group group(Long id) {
        return groupService.findById(id);
    }

    public Group saveGroup(GroupInputDto groupInputDto) {
        return groupService.save(groupInputDto);
    }

}
