package com.example.youtubedemo.Configuration;

import com.example.youtubedemo.bean.Student;
import com.example.youtubedemo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student alex=new Student(1L,"Alex","alex@gmail.com", LocalDate.of(2001, Month.JULY,23));
            Student ronya=new Student(3L,"Ronya","ronya@gmail.com",LocalDate.of(1995, Month.JULY,02));
            studentRepository.saveAll(List.of(alex,ronya));
        };

    }
}
