package com.example.youtubedemo.controller;

import com.example.youtubedemo.bean.Student;
import com.example.youtubedemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(method= RequestMethod.GET,path="/")
//http://localhost:8080/api/v1/student
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    //http://localhost:8080/api/v1/student/1
    @GetMapping("/api/v1/student/{id}")
    public Student getStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }
    //http://localhost:8080/api/v1/students
    @GetMapping("/api/v1/students")
    public List<Student> getStudent(){
        return studentService.getStudents();
    }
    //http://localhost:8080/api/v1/register
    /*{
        "id": 5,
            "name": "Prakash",
            "email": "prakash@gmail.com",
            "dateOfBirth": "2011-07-23"
    }*/
    @PostMapping("/api/v1/register")
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
//http://localhost:8080/api/v1/delete/5
    @DeleteMapping("/api/v1/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
    //http://localhost:8080/api/v1/update/1?name=Alexa
    //http://localhost:8080/api/v1/update/1?email=alexa@gmail.com
    @PutMapping("/api/v1/update/{id}")
    public void updateStudent(@PathVariable Long id,
                              @RequestParam(required = false) String name,
                              @RequestParam (required=false) String email){
        studentService.updateStudent(id,name,email);
    }
}
