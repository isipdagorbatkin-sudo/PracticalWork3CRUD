package org.example.demo.service;

import org.example.demo.model.StudentModel;

import java.util.List;

public interface StudentService {
    List<StudentModel> getAll();
    List<StudentModel> search(String query);
    StudentModel addStudent(StudentModel student);
    StudentModel updateStudent(StudentModel student);
    void deleteStudent(int id);
}
