package com.malimaquintino.javagraphql.model;

import com.malimaquintino.javagraphql.dto.RoleInputDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_role")
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_sequence")
    @SequenceGenerator(name = "role_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public static Role parseFromDto(RoleInputDto roleInputDto) {
        Role role = new Role();
        role.setId(roleInputDto.getId());
        role.setName(roleInputDto.getName());
        return role;
    }
}
