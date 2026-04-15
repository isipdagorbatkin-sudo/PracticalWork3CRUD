package org.example.demo.repository;

import org.example.demo.model.MenuItemModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MenuItemRepository {
    private List<MenuItemModel> menuItems = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    public List<MenuItemModel> getAll() { return new ArrayList<>(menuItems); }

    public MenuItemModel addMenuItem(MenuItemModel item) {
        item.setIdMenuItem(idCounter.getAndIncrement());
        menuItems.add(item);
        return item;
    }

    public MenuItemModel updateMenuItem(MenuItemModel item) {
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getIdMenuItem() == item.getIdMenuItem()) {
                menuItems.set(i, item);
                return item;
            }
        }
        return null;
    }

    public void deleteMenuItem(int id) {
        menuItems.removeIf(item -> item.getIdMenuItem() == id);
    }
}