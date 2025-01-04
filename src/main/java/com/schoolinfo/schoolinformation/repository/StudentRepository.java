package com.schoolinfo.schoolinformation.repository;

import com.schoolinfo.schoolinformation.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findBySchoolId(Long schoolId);
    Student findByIdentificationNumber(String identificationNumber);
    Student findByEmail(String email);
    List<Student> findByClassName(String className);
    List<Student> findBySchoolIdAndClassName(Long schoolId, String className);
}