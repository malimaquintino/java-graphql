package com.malimaquintino.javagraphql.model;

import com.malimaquintino.javagraphql.dto.CategoryInputDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_category")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    @SequenceGenerator(name = "category_sequence", allocationSize = 1)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @OneToOne
    private Group group;

    public static Category parseFromDto(CategoryInputDto categoryInputDto, Group group) {
        return Category.builder()
                .id(categoryInputDto.getId())
                .name(categoryInputDto.getName())
                .description(categoryInputDto.getDescription())
                .group(group)
                .build();
    }
}
