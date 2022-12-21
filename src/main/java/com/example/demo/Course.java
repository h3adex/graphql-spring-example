package com.example.demo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue
    private Integer id;

    private String courseName;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    Set<Student> students = new HashSet<Student>();

    protected Course() {}

    public Course(Integer id, String courseName){
        this.id = id;
        this.courseName = courseName;
    }

}
