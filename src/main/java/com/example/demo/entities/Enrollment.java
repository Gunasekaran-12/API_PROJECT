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
    
    private Long userId;  
    private Long courseId; 

    public Enrollment() {}

    public Enrollment(Long id, int progressPercentage, Date enrollmentDate, Long userId, Long courseId) {
        this.id = id;
        this.progressPercentage = progressPercentage;
        this.enrollmentDate = enrollmentDate;
        this.userId = userId;
        this.courseId = courseId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
