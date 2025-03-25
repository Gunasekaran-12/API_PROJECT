package com.example.demo.entities;

import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Enrollment {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int progressPercentage;
    private Date enrollmentDate;
    //private Course course;
    //private User user;
    
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="course_id",nullable=false)
    private Course course;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Enrollment() {}

    public Enrollment(Long id, int progressPercentage, Date enrollmentDate, Long userId, Long courseId, User user, Course course) {
         this.id = id;
         this.progressPercentage = progressPercentage;
         this.enrollmentDate = enrollmentDate;
         this.user = user;
         this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(int progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

  

}