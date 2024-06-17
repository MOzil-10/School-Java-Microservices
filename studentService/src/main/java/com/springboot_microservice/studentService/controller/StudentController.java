package com.springboot_microservice.studentService.controller;

import com.springboot_microservice.studentService.model.Student;
import com.springboot_microservice.studentService.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping("/{id}")
    public ResponseEntity<?> fetchStudentById(@PathVariable int id){
        return studentService.fetchStudentById(id);
    }
    @GetMapping
    public ResponseEntity<?> fetchStudents(){
        return studentService.fetchStudents();
    }
    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
}
