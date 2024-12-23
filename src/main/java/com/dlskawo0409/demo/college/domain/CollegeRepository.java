package com.dlskawo0409.demo.college.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CollegeRepository extends JpaRepository<College, Long> {
    @Query("SELECT c from College c " +
            "WHERE c.collegeName like '%name%'" +
            "OR c.collegeEnglishName like '%name%'  ")
    List<College> findByCollegeNameOrCollegeEnglishName(String name);

}
