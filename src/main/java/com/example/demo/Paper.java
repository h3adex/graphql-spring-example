package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Paper {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    protected Paper() {}

    public Paper(Integer id, String title, Student student) {
        this.id = id;
        this.title = title;
        this.student = student;
    }

}
