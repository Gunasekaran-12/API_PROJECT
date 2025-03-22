package com.example.demo.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Enrollment {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int progressPercentage;
    private Date enrollmentDate;
    //private Course course;
    //private User user;
    
    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;
    
    @ManyToOne
    @JoinColumn(name="user_id")
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

    public Enrollment(Long id, int progressPercentage, Date enrollmentDate, Long userId, Long courseId) {
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