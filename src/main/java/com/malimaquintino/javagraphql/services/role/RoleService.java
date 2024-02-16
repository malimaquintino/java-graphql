package com.malimaquintino.javagraphql.services.role;

import com.malimaquintino.javagraphql.dto.RoleInputDto;
import com.malimaquintino.javagraphql.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findRoles();

    Role findById(Long id);

    Role findByName(String name);

    Role save(RoleInputDto roleInputDto);
}
