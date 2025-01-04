package com.schoolinfo.schoolinformation.controller;


import com.schoolinfo.schoolinformation.model.School;
import com.schoolinfo.schoolinformation.services.SchoolService;
import dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<School>>> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        ApiResponse<List<School>> response = new ApiResponse<>(
                true,
                "Schools retrieved successfully",
                schools
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<School>> getSchoolById(@PathVariable Long id) {
        School school = schoolService.getSchoolById(id);
        ApiResponse<School> response = new ApiResponse<>(
                true,
                "School retrieved successfully",
                school
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/district/{district}")
    public ResponseEntity<ApiResponse<List<School>>> getSchoolsByDistrict(@PathVariable String district) {
        List<School> schools = schoolService.getSchoolsByDistrict(district);
        ApiResponse<List<School>> response = new ApiResponse<>(
                true,
                "Schools in district " + district + " retrieved successfully",
                schools
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<ApiResponse<School>> getSchoolByCode(@PathVariable String code) {
        School school = schoolService.getSchoolByCode(code);
        ApiResponse<School> response = new ApiResponse<>(
                true,
                "School with code " + code + " retrieved successfully",
                school
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<School>>> searchSchools(@RequestParam String name) {
        List<School> schools = schoolService.searchSchoolsByName(name);
        ApiResponse<List<School>> response = new ApiResponse<>(
                true,
                "Schools matching '" + name + "' retrieved successfully",
                schools
        );
        return ResponseEntity.ok(response);
    }
}
