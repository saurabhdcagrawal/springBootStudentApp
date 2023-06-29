package com.example.youtubedemo.repository;

import com.example.youtubedemo.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findById(int id);
    Student findByName(String name);
    //jpql
    //@Query("SELECT s from Student s where s.email=?1")
    Optional<Student> findByEmail(String email);
}
