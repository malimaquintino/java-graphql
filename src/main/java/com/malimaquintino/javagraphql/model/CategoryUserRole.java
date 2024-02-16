package com.malimaquintino.javagraphql.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "tb_category_user_role")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CategoryUserRoleID.class)
public class CategoryUserRole {

    @Id
    @JsonBackReference
    private Category category;

    @Id
    private User user;

    @Id
    private Role role;
}
