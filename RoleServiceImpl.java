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

    @Override public List<RoleModel> getAll() { return roleRepository.getAll(); }
    @Override public RoleModel addRole(RoleModel role) { return roleRepository.addRole(role); }
    @Override public RoleModel updateRole(RoleModel role) { return roleRepository.updateRole(role); }
    @Override public void deleteRole(int id) { roleRepository.deleteRole(id); }
}