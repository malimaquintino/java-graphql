package com.malimaquintino.javagraphql.services.role;

import com.malimaquintino.javagraphql.dto.RoleInputDto;
import com.malimaquintino.javagraphql.model.Role;
import com.malimaquintino.javagraphql.repository.RoleRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findRoles() {
        try {
            return roleRepository.findAll();
        } catch (Exception ex) {
            log.error("Error: {}", ex.getMessage());
            throw new RuntimeException("Error on find Role");
        }
    }

    @Override
    public Role findById(Long id) {
        try {
            return roleRepository.findById(id).orElse(null);
        } catch (Exception ex) {
            log.error("Error: {}", ex.getMessage());
            throw new RuntimeException("Error on find Role");
        }
    }

    @Override
    public Role findByName(String name) {
        try {
            return roleRepository.findByName(name);
        } catch (Exception ex) {
            log.error("Error: {}", ex.getMessage());
            throw new RuntimeException("Error on find Role");
        }
    }

    @Override
    public Role save(RoleInputDto roleInputDto) {
        try {
            return roleRepository.save(Role.parseFromDto(roleInputDto));
        } catch (Exception ex) {
            log.error("Error: {}", ex.getMessage());
            throw new RuntimeException("Error on save Role");
        }
    }
}
