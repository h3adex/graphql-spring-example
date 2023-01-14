package com.example.demo;


import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
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

    @QueryMapping
    Student student(@Argument Integer id) {
        return studentRepository.findById(id);
    }

    @QueryMapping
    Iterable<Student> findStudentsByFirstName(@Argument String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    @QueryMapping
    Iterable<Student> findStudentsByLastName(@Argument String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    @MutationMapping
    Student createStudent(@Argument StudentInput student){
        Student student1 = new Student(
                student.id(),
                student.firstName(),
                student.lastName(),
                student.registration()
        );

        return studentRepository.save(student1);
    }

    record StudentInput(Integer id, String firstName, String lastName, String registration) {}
}
