package com.example.youtubedemo.service;

import com.example.youtubedemo.bean.Student;
import com.example.youtubedemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

 public Student getStudent(Long id){
        Optional<Student> studentOptional=studentRepository.findById(id);
        if(!studentOptional.isPresent())
            throw new IllegalStateException("Student does not exist");
        return studentOptional.get();
    }
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional=studentRepository.findByEmail(student.getEmail());
        if(studentOptional.isPresent())
            throw new IllegalStateException("email taken");
        studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudent(Long id) {
        boolean exists=studentRepository.existsById(id);
        if(!exists)
            throw new IllegalStateException("Student does not exist");
        studentRepository.deleteById(id);
    }
    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student  student=studentRepository.findById(id).orElseThrow(()->new IllegalStateException("Student with id "+id+" does not exist"));
        if(name!=null && !name.isEmpty() && !student.getName().equals(name))
            student.setName(name);
        if(email!=null && !email.isEmpty() && !student.getEmail().equals(email)){
            Optional<Student> studentOptional=studentRepository.findByEmail(email);
            if(studentOptional.isPresent())
                throw new IllegalStateException("email taken");
            student.setEmail(email);
        }

    }
}

