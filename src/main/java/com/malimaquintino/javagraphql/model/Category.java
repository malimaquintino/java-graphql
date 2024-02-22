package com.malimaquintino.javagraphql.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.malimaquintino.javagraphql.dto.CategoryInputDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_category")
@Getter
@Setter
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

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<CategoryUserRole> usersRole = new HashSet<>();

    public static Category parseFromDto(CategoryInputDto categoryInputDto, Group group) {
        Category category = new Category();
        if (categoryInputDto.getId() > 0)
            category.setId(categoryInputDto.getId());
        category.setName(categoryInputDto.getName());
        category.setDescription(categoryInputDto.getDescription());
        category.setGroup(group);
        return category;
    }

    public void setUsersRole(Set<CategoryUserRole> userRoles) {
        this.usersRole.clear();
        if (userRoles != null) {
            this.usersRole = userRoles;
        }
    }
}
