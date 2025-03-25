package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    // public List<Enrollment> findByUserId(Long userId);
    // // JPQL query to find enrollments by user ID
    // @Query("SELECT e FROM Enrollment e WHERE e.userId = :userId")
    // public List<Enrollment> findByUser(Long userId);
}
