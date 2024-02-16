package com.malimaquintino.javagraphql.model;

import com.malimaquintino.javagraphql.dto.RoleInputDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_role")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_sequence")
    @SequenceGenerator(name = "role_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public static Role parseFromDto(RoleInputDto roleInputDto) {
        return Role.builder()
                .id(roleInputDto.getId())
                .name(roleInputDto.getName())
                .build();
    }
}
