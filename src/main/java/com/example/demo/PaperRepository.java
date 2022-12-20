package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaperRepository extends CrudRepository<Paper, Long> {

    List<Paper> findByTitle(String paperTitle);

    Paper findById(int id);
}
