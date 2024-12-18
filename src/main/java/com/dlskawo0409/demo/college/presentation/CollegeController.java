package com.dlskawo0409.demo.college.presentation;

import com.dlskawo0409.demo.college.application.CollegeService;
import com.dlskawo0409.demo.college.domain.College;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/colleges")
@Tag(name = "College", description = "대학 API")
public class CollegeController {

    private final CollegeService collegeService;

    @GetMapping("/name/{collegeName}")
    public ResponseEntity<?> getCollegeByCollegeName(@PathVariable("name") String collegeName){
        List<College> collegeList = collegeService.getCollegeByCollegeName(collegeName);
        return ResponseEntity.ok(collegeList);
    }


}
