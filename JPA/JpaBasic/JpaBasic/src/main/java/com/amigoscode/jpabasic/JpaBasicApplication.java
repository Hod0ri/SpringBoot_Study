package com.amigoscode.jpabasic;

import com.amigoscode.jpabasic.dto.Student;
import com.amigoscode.jpabasic.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaBasicApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student maria = new Student("Maria", "Jones", "maria.johnes@gmail.com", 21);
            studentRepository.save(maria);
        };

    }

}
