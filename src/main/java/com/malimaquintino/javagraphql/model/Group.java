package com.malimaquintino.javagraphql.model;

import com.malimaquintino.javagraphql.dto.GroupInputDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_group")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_sequence")
    @SequenceGenerator(name = "group_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public static Group parseFromDto(GroupInputDto groupInputDto) {
        return Group.builder()
                .id(groupInputDto.getId())
                .name(groupInputDto.getName())
                .build();
    }
}