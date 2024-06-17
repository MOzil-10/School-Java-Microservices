package com.springboot_microservice.studentService.response;

import com.springboot_microservice.studentService.dto.School;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private int id;
    private String name;
    private int age;
    private String gender;
    private School school;
}