package com.example.appspring.Config;
import com.example.appspring.entities.Teacher;
import com.example.appspring.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class TeacherConfig {
    @Bean
    CommandLineRunner commandLineRunnerTeacher(
            TeacherRepository repository){
        return  args -> {
            Teacher raquel =new Teacher(
                    "Raquel",
                    "raquel@esb.pt",
                    LocalDate.of(1998,02,14));
            Teacher rita =new Teacher(
                    "Rita",
                    "rita@esb.pt",
                    LocalDate.of(1982,02,14));

            repository.saveAll(List.of(raquel, rita));
        };

    }

}
