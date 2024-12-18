package com.dlskawo0409.demo.college.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CollegeRepository extends JpaRepository<College, Long> {
    List<College> findByCollegeNameOrCollegeEnglishName(String name);
}
