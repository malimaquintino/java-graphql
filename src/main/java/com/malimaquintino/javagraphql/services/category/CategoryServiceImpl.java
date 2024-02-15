package com.malimaquintino.javagraphql.services.category;

import com.malimaquintino.javagraphql.dto.CategoryInputDto;
import com.malimaquintino.javagraphql.model.Category;
import com.malimaquintino.javagraphql.model.Group;
import com.malimaquintino.javagraphql.repository.CategoryRepository;
import com.malimaquintino.javagraphql.services.group.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GroupService groupService;

    @Override
    public List<Category> findCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category save(CategoryInputDto categoryInputDto) {
        Group group = groupService.findById(categoryInputDto.getId());
        return categoryRepository.save(Category.parseFromDto(categoryInputDto, group));
    }
}
