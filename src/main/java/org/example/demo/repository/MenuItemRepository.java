package org.example.demo.repository;

import org.example.demo.model.MenuItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItemModel, Integer> {
    List<MenuItemModel> findByNameContainingIgnoreCase(String name);
}
