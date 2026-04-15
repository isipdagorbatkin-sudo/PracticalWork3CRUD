package org.example.demo.controller;

import org.example.demo.model.RoleModel;
import org.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public String getAllRoles(Model model) {
        model.addAttribute("roles", roleService.getAll());
        return "roleList";
    }

    @PostMapping("/add")
    public String addRole(@RequestParam String name) {
        roleService.addRole(new RoleModel(0, name));
        return "redirect:/roles";
    }

    @PostMapping("/update")
    public String updateRole(@RequestParam int idRole, @RequestParam String name) {
        roleService.updateRole(new RoleModel(idRole, name));
        return "redirect:/roles";
    }

    @PostMapping("/delete")
    public String deleteRole(@RequestParam int idRole) {
        roleService.deleteRole(idRole);
        return "redirect:/roles";
    }
}