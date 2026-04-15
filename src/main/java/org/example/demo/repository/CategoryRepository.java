package org.example.demo.repository;

import org.example.demo.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {
    List<CategoryModel> findByNameContainingIgnoreCase(String name);
}
