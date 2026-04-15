package org.example.demo.service;

import org.example.demo.model.StudentModel;
import org.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentModel> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<StudentModel> search(String query) {
        try {
            int id = Integer.parseInt(query);
            return studentRepository.findById(id).map(List::of).orElse(List.of());
        } catch (NumberFormatException e) {
            return studentRepository.findByNameContainingIgnoreCase(query);
        }
    }

    @Override
    public StudentModel addStudent(StudentModel student) {
        return studentRepository.save(student);
    }

    @Override
    public StudentModel updateStudent(StudentModel student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
