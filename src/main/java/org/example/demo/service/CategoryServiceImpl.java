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

    @Override
    public List<CategoryModel> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<CategoryModel> search(String query) {
        try {
            int id = Integer.parseInt(query);
            return categoryRepository.findById(id).map(List::of).orElse(List.of());
        } catch (NumberFormatException e) {
            return categoryRepository.findByNameContainingIgnoreCase(query);
        }
    }

    @Override
    public CategoryModel addCategory(CategoryModel category) {
        return categoryRepository.save(category);
    }

    @Override
    public CategoryModel updateCategory(CategoryModel category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }
}
