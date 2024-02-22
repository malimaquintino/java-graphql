package com.malimaquintino.javagraphql.services.category;

import com.malimaquintino.javagraphql.dto.CategoryInputDto;
import com.malimaquintino.javagraphql.model.*;
import com.malimaquintino.javagraphql.repository.CategoryRepository;
import com.malimaquintino.javagraphql.services.group.GroupService;
import com.malimaquintino.javagraphql.services.role.RoleService;
import com.malimaquintino.javagraphql.services.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Log4j2
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private GroupService groupService;

    @Override
    public List<Category> findCategories() {
        try {
            return categoryRepository.findAll();
        } catch (Exception ex) {
            log.error("Error: {}", ex.getMessage());
            throw new RuntimeException("Error on find Category");
        }
    }

    @Override
    public Category findById(Long id) {
        try {
            return categoryRepository.findById(id).orElse(null);
        } catch (Exception ex) {
            log.error("Error: {}", ex.getMessage());
            throw new RuntimeException("Error on find Category");
        }
    }

    @Override
    @Transactional
    public Category save(CategoryInputDto categoryInputDto) {
        try {
            Group group = groupService.findById(categoryInputDto.getGroupId());
            Category category = new Category();
            if (categoryInputDto.getId() > 0) {
                category = findById(categoryInputDto.getId());
                // if null throw exception
            }
            category = Category.parseFromDto(categoryInputDto, group);
            category.setUsersRole(findUsersAndRoles(categoryInputDto, category));
            return categoryRepository.save(category);
        } catch (Exception e) {
            log.info("");
        }
        return null;
    }

    private Set<CategoryUserRole> findUsersAndRoles(CategoryInputDto categoryInputDto, Category category) {
        try {
            Set<CategoryUserRole> userRoles = new HashSet<>();

            Role roleAdmin = roleService.findByName("Admin");
            Role roleMember = roleService.findByName("Member");

            if (Objects.isNull(roleAdmin) || Objects.isNull(roleMember)) {
                log.warn("Role not found");
                throw new NoSuchElementException("Role not found");
            }

            for (String memberEmail : categoryInputDto.getMembersEmail()) {
                User member = userService.findByEmail(memberEmail);

                if (Objects.isNull(member)) {
                    throw new NoSuchElementException("User not found");
                }

                CategoryUserRole categoryUserRole = new CategoryUserRole();
                categoryUserRole.setCategory(category);
                categoryUserRole.setUser(member);
                categoryUserRole.setRole(roleMember);
                userRoles.add(categoryUserRole);
            }

            for (String admEmail : categoryInputDto.getAdminsEmail()) {
                User adm = userService.findByEmail(admEmail);

                if (Objects.isNull(adm)) {
                    throw new NoSuchElementException("User not found");
                }

                CategoryUserRole categoryUserRole = new CategoryUserRole();
                categoryUserRole.setCategory(category);
                categoryUserRole.setUser(adm);
                categoryUserRole.setRole(roleAdmin);
                userRoles.add(categoryUserRole);
            }
            return userRoles;
        } catch (NoSuchElementException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (Exception ex) {
            log.error("Error: {}", ex.getMessage());
            throw new RuntimeException("Error on find Category");
        }
    }
}
