package com.schoolinfo.schoolinformation.services;

import com.schoolinfo.schoolinformation.exception.ResourceNotFoundException;
import com.schoolinfo.schoolinformation.model.School;
import com.schoolinfo.schoolinformation.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public School getSchoolById(Long id) {
        return schoolRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("School not found with id: " + id));
    }

    public List<School> getSchoolsByDistrict(String district) {
        return schoolRepository.findByDistrict(district);
    }

    public School getSchoolByCode(String code) {
        return schoolRepository.findByCode(code);
    }

    public List<School> searchSchoolsByName(String name) {
        return schoolRepository.findByNameContainingIgnoreCase(name);
    }
}