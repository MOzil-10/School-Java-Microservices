package com.springboot_microservice.schoolService.service;

import com.springboot_microservice.schoolService.model.School;
import com.springboot_microservice.schoolService.repo.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public School addSchool(School school) {
        return schoolRepository.save(school);
    }

    public List<School> getSchools() {
        return schoolRepository.findAll();
    }

    public School getSchoolById(int id) {
        return schoolRepository.findById(id).orElse(null);
    }

}
