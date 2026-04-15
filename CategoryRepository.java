package org.example.demo.repository;

import org.example.demo.model.CategoryModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CategoryRepository {
    private List<CategoryModel> categories = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    public List<CategoryModel> getAll() { return new ArrayList<>(categories); }

    public CategoryModel addCategory(CategoryModel category) {
        category.setIdCategory(idCounter.getAndIncrement());
        categories.add(category);
        return category;
    }

    public CategoryModel updateCategory(CategoryModel category) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getIdCategory() == category.getIdCategory()) {
                categories.set(i, category);
                return category;
            }
        }
        return null;
    }

    public void deleteCategory(int id) {
        categories.removeIf(c -> c.getIdCategory() == id);
    }
}