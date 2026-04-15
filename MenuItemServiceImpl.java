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

    @Override public List<MenuItemModel> getAll() { return menuItemRepository.getAll(); }
    @Override public MenuItemModel addMenuItem(MenuItemModel item) { return menuItemRepository.addMenuItem(item); }
    @Override public MenuItemModel updateMenuItem(MenuItemModel item) { return menuItemRepository.updateMenuItem(item); }
    @Override public void deleteMenuItem(int id) { menuItemRepository.deleteMenuItem(id); }
}