package com.schoolinfo.schoolinformation.controller;

import com.schoolinfo.schoolinformation.model.Student;
import com.schoolinfo.schoolinformation.services.StudentService;
import dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        ApiResponse<List<Student>> response = new ApiResponse<>(
                true,
                "Students retrieved successfully",
                students
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        ApiResponse<Student> response = new ApiResponse<>(
                true,
                "Student retrieved successfully",
                student
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<ApiResponse<List<Student>>> getStudentsBySchool(@PathVariable Long schoolId) {
        List<Student> students = studentService.getStudentsBySchool(schoolId);
        ApiResponse<List<Student>> response = new ApiResponse<>(
                true,
                "Students from school " + schoolId + " retrieved successfully",
                students
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ApiResponse<Student>> getStudentByEmail(@PathVariable String email) {
        Student student = studentService.getStudentByEmail(email);
        ApiResponse<Student> response = new ApiResponse<>(
                true,
                "Student with Email " + email + " retrieved successfully",
                student
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/ic/{identificationNumber}")
    public ResponseEntity<ApiResponse<Student>> getStudentByIC(@PathVariable String identificationNumber) {
        Student student = studentService.getStudentByIdentificationNumber(identificationNumber);
        ApiResponse<Student> response = new ApiResponse<>(
                true,
                "Student with IC " + identificationNumber + " retrieved successfully",
                student
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/class/{className}")
    public ResponseEntity<ApiResponse<List<Student>>> getStudentsByClass(@PathVariable String className) {
        List<Student> students = studentService.getStudentsByClass(className);
        ApiResponse<List<Student>> response = new ApiResponse<>(
                true,
                "Students from class " + className + " retrieved successfully",
                students
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/school/{schoolId}/class/{className}")
    public ResponseEntity<ApiResponse<List<Student>>> getStudentsBySchoolAndClass(
            @PathVariable Long schoolId,
            @PathVariable String className) {
        List<Student> students = studentService.getStudentsBySchoolAndClass(schoolId, className);
        ApiResponse<List<Student>> response = new ApiResponse<>(
                true,
                "Students from school " + schoolId + " and class " + className + " retrieved successfully",
                students
        );
        return ResponseEntity.ok(response);
    }
}