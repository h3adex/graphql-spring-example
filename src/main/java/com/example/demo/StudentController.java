package com.example.demo;


import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // used for graphql annotations
    @QueryMapping
    Iterable<Student> students() {
        return studentRepository.findAll();
    }
}
