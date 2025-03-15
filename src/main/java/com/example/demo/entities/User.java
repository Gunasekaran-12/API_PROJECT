package com.example.demo.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String  name;
     @Email(message = "Invalid email format")
     private String  email;
     @NotBlank(message = "Description is required")
     private String  password;
     private String  preferredLanguage;
     private String  ProfilePicture;
     private String  enrolledCourses;
    public User(){

    }
    public User(long id, String name, String email, String password, String preferredLanguage, String profilePicture,
            String enrolledCourses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.preferredLanguage = preferredLanguage;
        this.ProfilePicture = profilePicture;
        this.enrolledCourses = enrolledCourses;
    }
    public long getId() {
        return id;
    }
    public void setId(Long id2) {
        this.id = id2;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPreferredLanguage() {
        return preferredLanguage;
    }
    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }
    public String getProfilePicture() {
        return ProfilePicture;
    }
    public void setProfilePicture(String profilePicture) {
        ProfilePicture = profilePicture;
    }
    public String getEnrolledCourses() {
        return enrolledCourses;
    }
    public void setEnrolledCourses(String enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
}