package org.example.demo.service;

import org.example.demo.model.MenuItemModel;
import org.example.demo.repository.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {
    private final MenuItemRepository menuItemRepository;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public List<MenuItemModel> getAll() {
        return menuItemRepository.findAll();
    }

    @Override
    public List<MenuItemModel> search(String query) {
        try {
            int id = Integer.parseInt(query);
            return menuItemRepository.findById(id).map(List::of).orElse(List.of());
        } catch (NumberFormatException e) {
            return menuItemRepository.findByNameContainingIgnoreCase(query);
        }
    }

    @Override
    public MenuItemModel addMenuItem(MenuItemModel item) {
        return menuItemRepository.save(item);
    }

    @Override
    public MenuItemModel updateMenuItem(MenuItemModel item) {
        return menuItemRepository.save(item);
    }

    @Override
    public void deleteMenuItem(int id) {
        menuItemRepository.deleteById(id);
    }
}
