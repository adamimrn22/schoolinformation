package com.schoolinfo.schoolinformation.repository;


import com.schoolinfo.schoolinformation.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {
    List<School> findByDistrict(String district);
    School findByCode(String code);
    List<School> findByNameContainingIgnoreCase(String name);

    @Query("SELECT s FROM School s WHERE s.postcode = :postcode")
    List<School> findByPostcode(String postcode);
}