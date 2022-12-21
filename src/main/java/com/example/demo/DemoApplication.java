package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.Arrays;


@SpringBootApplication
public class DemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public ApplicationRunner demo(
			StudentRepository studentRepository,
			PaperRepository paperRepository,
			CourseRepository courseRepository
	) {
		return (args) -> {
			Course course1 = new Course(1, "Software Architecture");
			Course course2 = new Course(2, "Big Data");
			Course course3 = new Course(3, "Object Orientated Programming III");
			courseRepository.saveAll(Arrays.asList(course1, course2, course3));

			Student student1 = new Student(1, "Mauritz", "ABC", "1234");
			Student student2 = new Student(2, "Anas", "DEF", "3456");
			Student student3 = new Student(3, "Lea", "ABC", "789");
			Student student4 = new Student(4, "Anna", "DEF", "912");
			studentRepository.saveAll(Arrays.asList(student1, student2, student3, student4));

			Paper paper1 = new Paper(1, "Spring & GraphQL", studentRepository.findById(1));
			Paper paper2 = new Paper(2, "Spring & Rest", studentRepository.findById(2));
			paperRepository.saveAll(Arrays.asList(paper1, paper2));

			for (Student student : studentRepository.findAll()) {
				log.info(student.toString());
			}

			student1.getCourses().addAll(Arrays.asList(course1, course2));
			studentRepository.save(student1);

			student2.getCourses().add(course3);
			studentRepository.save(student2);

		};
	}
}
