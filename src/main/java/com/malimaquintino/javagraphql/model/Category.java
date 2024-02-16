package com.malimaquintino.javagraphql.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.malimaquintino.javagraphql.dto.CategoryInputDto;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_category")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    @SequenceGenerator(name = "category_sequence", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToOne
    private Group group;

    @JsonManagedReference
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<CategoryUserRole> usersRole = new HashSet<>();

    public static Category parseFromDto(CategoryInputDto categoryInputDto, Group group) {
        return Category.builder()
                .id(categoryInputDto.getId())
                .name(categoryInputDto.getName())
                .description(categoryInputDto.getDescription())
                .group(group)
                .build();
    }
}
