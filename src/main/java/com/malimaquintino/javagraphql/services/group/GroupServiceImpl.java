package com.malimaquintino.javagraphql.services.group;

import com.malimaquintino.javagraphql.dto.GroupInputDto;
import com.malimaquintino.javagraphql.model.Group;
import com.malimaquintino.javagraphql.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<Group> findGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Group findById(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Override
    public Group save(GroupInputDto groupInputDto) {
        return groupRepository.save(Group.parseFromDto(groupInputDto));
    }
}
