package org.example.demo.repository;

import org.example.demo.model.RoleModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class RoleRepository {
    private List<RoleModel> roles = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    public List<RoleModel> getAll() { return new ArrayList<>(roles); }

    public RoleModel addRole(RoleModel role) {
        role.setIdRole(idCounter.getAndIncrement());
        roles.add(role);
        return role;
    }

    public RoleModel updateRole(RoleModel role) {
        for (int i = 0; i < roles.size(); i++) {
            if (roles.get(i).getIdRole() == role.getIdRole()) {
                roles.set(i, role);
                return role;
            }
        }
        return null;
    }

    public void deleteRole(int id) {
        roles.removeIf(role -> role.getIdRole() == id);
    }
}