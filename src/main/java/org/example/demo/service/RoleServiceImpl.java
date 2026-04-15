package org.example.demo.service;

import org.example.demo.model.RoleModel;
import org.example.demo.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleModel> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public List<RoleModel> search(String query) {
        try {
            int id = Integer.parseInt(query);
            return roleRepository.findById(id).map(List::of).orElse(List.of());
        } catch (NumberFormatException e) {
            return roleRepository.findByNameContainingIgnoreCase(query);
        }
    }

    @Override
    public RoleModel addRole(RoleModel role) {
        return roleRepository.save(role);
    }

    @Override
    public RoleModel updateRole(RoleModel role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(int id) {
        roleRepository.deleteById(id);
    }
}
