package org.example.demo.controller;

import org.example.demo.model.StudentModel;
import org.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String getAllStudents(@RequestParam(required = false) String search, Model model) {
        if (search != null && !search.isBlank()) {
            model.addAttribute("students", studentService.search(search));
            model.addAttribute("search", search);
        } else {
            model.addAttribute("students", studentService.getAll());
        }
        return "studentList";
    }

    @PostMapping("/add")
    public String addStudent(@RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam int age) {
        studentService.addStudent(new StudentModel(0, name, surname, age));
        return "redirect:/students";
    }

    @PostMapping("/update")
    public String updateStudent(@RequestParam int id,
                                @RequestParam String name,
                                @RequestParam String surname,
                                @RequestParam int age) {
        studentService.updateStudent(new StudentModel(id, name, surname, age));
        return "redirect:/students";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam int id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
