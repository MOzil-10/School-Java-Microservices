package com.springboot_microservice.studentService.repo;

import com.springboot_microservice.studentService.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends MongoRepository<Student, Integer> {
}
