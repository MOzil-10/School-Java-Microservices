package com.springboot_microservice.studentService.services;

import com.springboot_microservice.studentService.dto.School;
import com.springboot_microservice.studentService.model.Student;
import com.springboot_microservice.studentService.repo.StudentsRepository;
import com.springboot_microservice.studentService.response.StudentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentsRepository studentsRepository;
    public RestTemplate restTemplate;

    public StudentService(StudentsRepository studentsRepository, RestTemplate restTemplate){
        this.studentsRepository = studentsRepository;
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<?> createStudent(Student student) {
        try {
            Student savedStudent = studentsRepository.save(student);
            return new ResponseEntity<>(savedStudent, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> fetchStudentById(int id) {
        Optional<Student> student = studentsRepository.findById(id);
        if (student.isPresent()) {
            School school = restTemplate.getForObject("http://localhost:8082/school/" + student.get().getSchoolId(), School.class);
            StudentResponse studentResponse = new StudentResponse(
                    student.get().getId(),
                    student.get().getName(),
                    student.get().getAge(),
                    student.get().getGender(),
                    school
            );
            return new ResponseEntity<>(studentResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Student Found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> fetchStudents() {
        List<Student> students = studentsRepository.findAll();
        if (!students.isEmpty()) {
            return new ResponseEntity<>(students, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Students", HttpStatus.NOT_FOUND);
        }
    }
}
