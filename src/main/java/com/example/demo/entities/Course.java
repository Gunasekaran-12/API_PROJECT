package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    private String difficultyLevel;

    public Course() {}

    public Course(Long id, String name, String description, String difficultyLevel, List<Enrollment> enrolledUsers) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.difficultyLevel = difficultyLevel;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    @OneToMany(mappedBy="course",cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Enrollment> EnrolledCourse=new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name="language_id")
    private Language language;
  
}
