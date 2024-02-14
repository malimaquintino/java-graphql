package com.malimaquintino.javagraphql.model;

import com.malimaquintino.javagraphql.dto.RoleInputDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_role")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", allocationSize = 1)
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
