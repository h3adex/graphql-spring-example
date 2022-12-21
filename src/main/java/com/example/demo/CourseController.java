package com.example.demo;


import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CourseController {
    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {

        this.courseRepository = courseRepository;
    }

    // used for graphql annotations
    @QueryMapping
    Iterable<Course> courses() {
        return courseRepository.findAll();
    }

    @QueryMapping
    Course course(@Argument Integer id) {
        return courseRepository.findById(id);
    }
}
