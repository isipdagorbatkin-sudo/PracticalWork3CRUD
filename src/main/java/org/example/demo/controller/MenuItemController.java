package org.example.demo.controller;

import org.example.demo.model.MenuItemModel;
import org.example.demo.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu-items")
public class MenuItemController {
    @Autowired
    private MenuItemService menuItemService;

    @GetMapping
    public String getAllMenuItems(@RequestParam(required = false) String search, Model model) {
        if (search != null && !search.isBlank()) {
            model.addAttribute("menuItems", menuItemService.search(search));
            model.addAttribute("search", search);
        } else {
            model.addAttribute("menuItems", menuItemService.getAll());
        }
        return "menuItemList";
    }

    @PostMapping("/add")
    public String addMenuItem(@RequestParam String name,
                              @RequestParam String description,
                              @RequestParam double price,
                              @RequestParam(defaultValue = "false") boolean isAvailable,
                              @RequestParam String imageUrl,
                              @RequestParam int categoryId) {
        menuItemService.addMenuItem(new MenuItemModel(0, name, description, price, isAvailable, imageUrl, categoryId));
        return "redirect:/menu-items";
    }

    @PostMapping("/update")
    public String updateMenuItem(@RequestParam int idMenuItem,
                                 @RequestParam String name,
                                 @RequestParam String description,
                                 @RequestParam double price,
                                 @RequestParam(defaultValue = "false") boolean isAvailable,
                                 @RequestParam String imageUrl,
                                 @RequestParam int categoryId) {
        menuItemService.updateMenuItem(new MenuItemModel(idMenuItem, name, description, price, isAvailable, imageUrl, categoryId));
        return "redirect:/menu-items";
    }

    @PostMapping("/delete")
    public String deleteMenuItem(@RequestParam int idMenuItem) {
        menuItemService.deleteMenuItem(idMenuItem);
        return "redirect:/menu-items";
    }
}
