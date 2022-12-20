package com.example.demo;

import java.util.List;

import com.example.demo.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    Student findById(int id);
}