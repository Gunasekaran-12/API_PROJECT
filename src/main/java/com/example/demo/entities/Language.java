package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String languageName;

    public Language() {}

    public Language(Long id, String languageName) {
        this.id = id;
        this.languageName = languageName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    @OneToMany(mappedBy="language",cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Course> courses=new ArrayList<>();
}
