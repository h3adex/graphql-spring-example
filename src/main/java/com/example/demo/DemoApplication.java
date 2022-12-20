package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public ApplicationRunner demo(StudentRepository studentRepository, PaperRepository courseRepository) {
		return (args) -> {
			studentRepository.save(new Student(1, "Mau", "Ritz", "1234"));
			studentRepository.save(new Student(2, "An", "as", "3456"));
			studentRepository.save(new Student(3, "Foo", "Bar", "789"));

			for (Student student : studentRepository.findAll()) {
				log.info(student.toString());
			}

			courseRepository.save(new Paper(1, "Spring & GraphQL", studentRepository.findById(1)));
			courseRepository.save(new Paper(2, "Spring & Rest", studentRepository.findById(2)));

		};
	}
}
