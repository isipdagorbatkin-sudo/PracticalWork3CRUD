package org.example.demo.controller;

import org.example.demo.model.CategoryModel;
import org.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String getAllCategories(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "categoryList";
    }

    @PostMapping("/add")
    public String addCategory(@RequestParam String name, @RequestParam String description) {
        categoryService.addCategory(new CategoryModel(0, name, description));
        return "redirect:/categories";
    }

    @PostMapping("/update")
    public String updateCategory(@RequestParam int idCategory, @RequestParam String name, @RequestParam String description) {
        categoryService.updateCategory(new CategoryModel(idCategory, name, description));
        return "redirect:/categories";
    }

    @PostMapping("/delete")
    public String deleteCategory(@RequestParam int idCategory) {
        categoryService.deleteCategory(idCategory);
        return "redirect:/categories";
    }
}