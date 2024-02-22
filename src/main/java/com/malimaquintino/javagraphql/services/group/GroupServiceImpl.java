package com.malimaquintino.javagraphql.services.group;

import com.malimaquintino.javagraphql.dto.GroupInputDto;
import com.malimaquintino.javagraphql.model.Group;
import com.malimaquintino.javagraphql.repository.GroupRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<Group> findGroups() {
        try {
            return groupRepository.findAll();
        } catch (Exception ex) {
            log.error("Error: {}", ex.getMessage());
            throw new RuntimeException("Error on find Group");
        }
    }

    @Override
    public Group findById(Long id) {
        try {
            return groupRepository.findById(id).orElse(null);
        } catch (Exception ex) {
            log.error("Error: {}", ex.getMessage());
            throw new RuntimeException("Error on find Group");
        }
    }

    @Override
    public Group save(GroupInputDto groupInputDto) {
        try {
            return groupRepository.save(Group.parseFromDto(groupInputDto));
        } catch (Exception ex) {
            log.error("Error: {}", ex.getMessage());
            throw new RuntimeException("Error on save Group");
        }
    }
}
