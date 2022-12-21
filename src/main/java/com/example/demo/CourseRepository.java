package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {

    List<Course> findByCourseName(String courseName);

    Course findById(int id);
}
