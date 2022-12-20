package com.example.demo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String registration;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Paper> papers = new ArrayList<>();

    protected Student() {}

    public Student(Integer id, String firstName, String lastName, String registration) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registration = registration;
    }
}
