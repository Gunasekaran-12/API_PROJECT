package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    void deleteById(@SuppressWarnings("null") Long id);

    // JPQL query to find a user by email
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(String email);
}
