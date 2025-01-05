package com.schoolinfo.schoolinformation.repository;

import com.schoolinfo.schoolinformation.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
  List<Student> findBySchoolId(Long schoolId);

  Student findByIdentificationNumber(String identificationNumber);

  Student findByEmail(String email);

  @Query("SELECT s FROM Student s JOIN FETCH s.school WHERE s.id = :id")
  Optional<Student> findByIdWithSchool(Long id);
}