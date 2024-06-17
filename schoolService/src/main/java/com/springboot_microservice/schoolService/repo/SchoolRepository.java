package com.springboot_microservice.schoolService.repo;

import com.springboot_microservice.schoolService.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School,Integer> {
}
