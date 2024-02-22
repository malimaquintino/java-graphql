package com.malimaquintino.javagraphql.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tb_category_user_role")
@Getter
@Setter
@IdClass(CategoryUserRoleID.class)
public class CategoryUserRole {

    @Id
    @JsonBackReference
    private Category category;

    @Id
    private User user;

    @Id
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryUserRole that = (CategoryUserRole) o;
        return Objects.equals(category, that.category) && Objects.equals(user, that.user) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, user, role);
    }
}
