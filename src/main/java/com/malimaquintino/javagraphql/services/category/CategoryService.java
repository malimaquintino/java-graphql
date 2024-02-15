package com.malimaquintino.javagraphql.services.category;

import com.malimaquintino.javagraphql.dto.CategoryInputDto;
import com.malimaquintino.javagraphql.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findCategories();

    Category findById(Long id);

    Category save(CategoryInputDto categoryInputDto);
}
