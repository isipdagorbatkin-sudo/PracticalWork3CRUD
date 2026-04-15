package org.example.demo.service;

import org.example.demo.model.MenuItemModel;

import java.util.List;

public interface MenuItemService {
    List<MenuItemModel> getAll();
    List<MenuItemModel> search(String query);
    MenuItemModel addMenuItem(MenuItemModel item);
    MenuItemModel updateMenuItem(MenuItemModel item);
    void deleteMenuItem(int id);
}
