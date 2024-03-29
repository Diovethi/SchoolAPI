package com.example.appspring.Config;

import com.example.appspring.entities.Student;
import com.example.appspring.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunnerStudent(
                StudentRepository repository){
        return  args -> {
            Student joao =new Student(
                    "Joao",
                    "joao@gmail.com",
                    LocalDate.of(1998,02,14));
            Student joana =new Student(
                    "Joana",
                    "joana@gmail.com",
                    LocalDate.of(1982,02,14));

            repository.saveAll(List.of(joao, joana));
        };

    }
}
