package com.example.demo.services;

import com.example.demo.entities.Course;
import com.example.demo.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Courseservice {

    private final CourseRepository repository;

    @Autowired
    public Courseservice(CourseRepository repository) {
        this.repository = repository;
    }

    // Save or update a course
    public Course saveOrUpdateCourse(Course course) {
        return repository.save(course);
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    // Get course by ID
    public Course getCourseById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Update course details
    public Course updateCourse(Long id, Course updatedCourse) {
        updatedCourse.setId(id);
        return repository.save(updatedCourse);
    }

    // Delete a course
    public String deleteCourse(Long id) {
        repository.deleteById(id);
        return "Course deleted successfully";
    }

    // Get paginated courses
    public Page<Course> paginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return repository.findAll(pageable);
    }

    // Get courses by difficulty level
    public List<Course> getCoursesByDifficulty(String difficultyLevel) {
        return repository.findByDifficultyLevel(difficultyLevel);
    }

    // Get course by name
    public Course getCoursesByName(String name) {
        return repository.findByName(name);
    }
}


// package com.example.demo.services;

// import com.example.demo.entities.Course;
// import com.example.demo.repositories.CourseRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class Courseservice {
    
//     @Autowired
//     private CourseRepository repository;

//     public Course saveOrUpdateCourse(Course course) {
//         return repository.save(course);
//     }

//     public List<Course> getAllCourses() {
//         return repository.findAll();
//     }

//     public Course getCourseById(Long id) {
//         Optional<Course> course = repository.findById(id);
//         return course.orElse(null);
//     }

//     public Course updateCourse(Long id, Course updatedCourse) {
//         updatedCourse.setId(id);
//         return repository.save(updatedCourse);
//     }

//     public String deleteCourse(Long id) {
//         repository.deleteById(id);
//         return "Course deleted successfully";
//     }

//      public Page<Course> paginated(int page,int size){
//         Pageable pageable=PageRequest.of(page,size,Sort.by("id").ascending());
//         return repository.findAll(pageable);
//     }

//     public List<Course> getCoursesByDifficulty(String difficultyLevel) {
//         return repository.findByDifficultyLevel(difficultyLevel);
//     }

//     public Course getCoursesByName(String name) {
//         return repository.findByName(name);
//     }
// }
