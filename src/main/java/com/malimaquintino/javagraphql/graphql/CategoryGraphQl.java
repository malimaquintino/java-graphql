package com.malimaquintino.javagraphql.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.malimaquintino.javagraphql.dto.CategoryInputDto;
import com.malimaquintino.javagraphql.model.Category;
import com.malimaquintino.javagraphql.services.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private CategoryService categoryService;

    public List<Category> categories() {
        return categoryService.findCategories();
    }

    public Category category(Long id) {
        return categoryService.findById(id);
    }

    public Category saveCategory(CategoryInputDto categoryInputDto) {
        return categoryService.save(categoryInputDto);
    }
}
