package org.example.demo.controller;

import org.example.demo.model.StudentModel;
import org.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAll());
        return "studentList";
    }

    @PostMapping("/students/add")
    public String addStudents(@RequestParam String name,
                              @RequestParam String surname,
                              @RequestParam int age) {
        StudentModel studentModel = new StudentModel(0, name, surname, age);
        studentService.addStudent(studentModel);
        return "redirect:/students";
    }
}
