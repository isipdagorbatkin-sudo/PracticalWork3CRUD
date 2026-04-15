package org.example.demo.service;

import org.example.demo.model.CategoryModel;
import org.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override public List<CategoryModel> getAll() { return categoryRepository.getAll(); }
    @Override public CategoryModel addCategory(CategoryModel category) { return categoryRepository.addCategory(category); }
    @Override public CategoryModel updateCategory(CategoryModel category) { return categoryRepository.updateCategory(category); }
    @Override public void deleteCategory(int id) { categoryRepository.deleteCategory(id); }
}