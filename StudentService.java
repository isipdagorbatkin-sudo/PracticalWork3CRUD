package org.example.demo.service;

import org.example.demo.model.StudentModel;

import java.util.List;

public interface StudentService {
    public List<StudentModel> getAll();
    public StudentModel addStudent(StudentModel student);
    public StudentModel updateStudent(StudentModel student);
    public void deleteStudent(int id);
}
