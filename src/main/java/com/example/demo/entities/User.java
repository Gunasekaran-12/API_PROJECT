package com.example.demo.entities;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  name;
    
    @Column(unique = true, nullable = false)
    @Email(message = "Invalid email format")
    private String  email;
    
    @NotBlank(message = "Description is required")
        private String  password;
        private String  preferredLanguage;
        private String  ProfilePicture;
        
        //public List<String> enrolledCoursesList;
        
        @OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval=true)
        @JsonIgnore  //recursion prevents.....
        @JsonManagedReference
            private List<Enrollment> EnrolledCourses=new ArrayList<>();
 
        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
            private List<LearningGoal> learningGoals = new ArrayList<>();
    

        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courses; 

        public List<Enrollment> getEnrolledCourses() {
            return EnrolledCourses;
        }
            
        public List<String> getEnrolledCoursesList() {
            if (EnrolledCourses == null) {
               return new ArrayList<>();
            }
            return EnrolledCourses.stream()
                .map(enrollment -> enrollment.getCourse().getName())
                .collect(Collectors.toList());
        }
     
         public User(){ //default constructor
     
         }
         
         

         public User(Long id, String name, @Email(message = "Invalid email format") String email,
         @NotBlank(message = "Description is required") String password, String preferredLanguage,
         String profilePicture, String enrolledCourses) {
             this.id = id;
             this.name = name;
             this.email = email;
             this.password = password;
             this.preferredLanguage = preferredLanguage;
             this.ProfilePicture = profilePicture;
         }
         
         public Long getId() {
             return id;
         }
         public void setId(Long id) {
             this.id = id;
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
         // public String getEnrolledCourses() {
         //     return enrolledCourses;
         // }
         
         public void setEnrolledCourses(List<Enrollment> enrolledCourses) {
            this.EnrolledCourses = enrolledCourses;
        }

    public List<LearningGoal> getLearningGoals() {
        return learningGoals;
    }

    //Mapping....

}