package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Enrollment;
import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByUserId(Long userId);
    // JPQL query to find enrollments by user ID
    @Query("SELECT e FROM Enrollment e WHERE e.userId = :userId")
    List<Enrollment> findByUser(Long userId);
}
