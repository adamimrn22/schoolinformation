package com.schoolinfo.schoolinformation.services;

import com.schoolinfo.schoolinformation.exception.ResourceNotFoundException;
import com.schoolinfo.schoolinformation.model.Student;
import com.schoolinfo.schoolinformation.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    public List<Student> getStudentsBySchool(String schoolCode) {
        return studentRepository.findBySchoolCode(schoolCode);
    }

    public Student getStudentByIdentificationNumber(String identificationNumber) {
        return studentRepository.findByIdentificationNumber(identificationNumber);
    }

    public Student getStudentWithSchool(Long id) {
        return studentRepository.findByIdWithSchool(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

}
