package com.malimaquintino.javagraphql.services.role;

import com.malimaquintino.javagraphql.dto.RoleInputDto;
import com.malimaquintino.javagraphql.model.Role;
import com.malimaquintino.javagraphql.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Role save(RoleInputDto roleInputDto) {
        return roleRepository.save(Role.parseFromDto(roleInputDto));
    }
}
