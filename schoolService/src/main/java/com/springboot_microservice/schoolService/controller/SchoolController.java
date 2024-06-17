package com.springboot_microservice.schoolService.controller;

import com.springboot_microservice.schoolService.model.School;
import com.springboot_microservice.schoolService.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private final SchoolService schoolService;

    public SchoolController (SchoolService service){
        this.schoolService = service;
    }

    @PostMapping
    public School addSchool(@RequestBody School school) {
        return schoolService.addSchool(school);
    }

    @GetMapping
    public List<School> getSchools() {
        return schoolService.getSchools();
    }

    @GetMapping("/{id}")
    public School getSchoolById(int id) {
        return schoolService.getSchoolById(id);
    }
}
