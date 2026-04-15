package org.example.demo.repository;

import org.example.demo.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentModel, Integer> {
    List<StudentModel> findByNameContainingIgnoreCase(String name);
}
