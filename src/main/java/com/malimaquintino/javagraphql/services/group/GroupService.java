package com.malimaquintino.javagraphql.services.group;

import com.malimaquintino.javagraphql.dto.GroupInputDto;
import com.malimaquintino.javagraphql.model.Group;

import java.util.List;

public interface GroupService {
    List<Group> findGroups();

    Group findById(Long id);

    Group save(GroupInputDto groupInputDto);
}
