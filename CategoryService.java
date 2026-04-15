package org.example.demo.service;
import org.example.demo.model.CategoryModel;
import java.util.List;

public interface CategoryService {
    List<CategoryModel> getAll();
    CategoryModel addCategory(CategoryModel category);
    CategoryModel updateCategory(CategoryModel category);
    void deleteCategory(int id);
}