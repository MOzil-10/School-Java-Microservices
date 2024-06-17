package com.springboot_microservice.studentService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "students")
public class Student {
    @Id
    private int id;
    private String name;
    private int age;
    private String gender;
    private Integer schoolId;
}
