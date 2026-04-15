package org.example.demo.service;

import org.example.demo.model.RoleModel;

import java.util.List;

public interface RoleService {
    List<RoleModel> getAll();
    List<RoleModel> search(String query);
    RoleModel addRole(RoleModel role);
    RoleModel updateRole(RoleModel role);
    void deleteRole(int id);
}
