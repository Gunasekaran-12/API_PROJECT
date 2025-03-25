package com.example.demo.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    void deleteById(@SuppressWarnings("null") Long id);

    // JPQL query to find a user by email
    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    // Fetch user with courses (only if 'courses' exists in 'User' entity)
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.courses WHERE u.id = :id")
    Optional<User> findByIdWithCourses(@Param("id") Long id);
}
