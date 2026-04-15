package org.example.demo.repository;

import org.example.demo.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleModel, Integer> {
    List<RoleModel> findByNameContainingIgnoreCase(String name);
}
