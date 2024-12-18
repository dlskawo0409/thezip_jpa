package com.dlskawo0409.demo.college.application;

import com.dlskawo0409.demo.college.domain.College;
import com.dlskawo0409.demo.college.domain.CollegeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CollegeService {

    private  final CollegeRepository collegeRepository;

    public List<College> getCollegeByCollegeName(String collegeName){
        return collegeRepository.findByCollegeNameOrCollegeEnglishName(collegeName);
    }
}
