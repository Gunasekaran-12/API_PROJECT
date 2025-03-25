package com.example.demo.services;
import com.example.demo.entities.Course;
import com.example.demo.entities.Enrollment;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Enrollmentservice {

    private EnrollmentRepository rep;
    private CourseRepository courserep;
    
        @Autowired
        public void EnrollmentService(EnrollmentRepository rep, CourseRepository courserep) {
            this.rep = rep;
        this.courserep = courserep;
    }

    // Add a new enrollment
    public Enrollment addEnrollment(Enrollment enrollment) {
        Course course = courserep.findById(enrollment.getCourse().getId())
            .orElseThrow(() -> new RuntimeException("Course not found"));

        enrollment.setCourse(course);
        return rep.save(enrollment);
    }

    // Get all enrollments
    public List<Enrollment> getAllEnrollments() {
        return rep.findAll();
    }

    // Get enrollments by user ID
    public Optional<Enrollment> getEnrollmentsByUserId(Long userId) {
        return rep.findById(userId);
    }

    // Update progress of an enrollment
    public Enrollment updateEnrollmentProgress(Long enrollmentId, Enrollment updatedEnrollment) {
        Enrollment existingEnrollment = rep.findById(enrollmentId)
            .orElseThrow(() -> new RuntimeException("Enrollment not found"));

        existingEnrollment.setProgressPercentage(updatedEnrollment.getProgressPercentage());
        return rep.save(existingEnrollment);
    }

    // Delete an enrollment
    public String deleteEnrollment(Long enrollmentId) {
        if (!rep.existsById(enrollmentId)) {
            throw new RuntimeException("Enrollment not found");
        }
        rep.deleteById(enrollmentId);
        return "Enrollment deleted successfully";
    }

    // Get paginated enrollments
    public Page<Enrollment> getPaginatedEnrollments(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return rep.findAll(pageable);
    }

    public Enrollment enrollInCourse(Enrollment enrollment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enrollInCourse'");
    }

    public Page<Enrollment> paginated(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'paginated'");
    }
}

// package com.example.demo.services;

// import com.example.demo.entities.*;
// import com.example.demo.repositories.EnrollmentRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class Enrollmentservice {
    
//     EnrollmentRepository repository;
//     @Autowired
//     Enrollmentservice(EnrollmentRepository er)
//     {
//         repository=er;
//     }
//     public Enrollment enrollInCourse(Enrollment enrollment) {
//         return repository.save(enrollment);
//     }

//     public List<Enrollment> getEnrollmentsByUserId() {
//         return repository.findAll();
//     }

//     public Enrollment updateEnrollmentProgress(Long id, Enrollment updatedEnrollment) {
//         updatedEnrollment.setId(id);
//         return repository.save(updatedEnrollment);
//     }

//     public String deleteEnrollment(Long id) {
//         if (!repository.existsById(id)) {
//             throw new RuntimeException("Enrollment not found");
//         }
//         repository.deleteById(id);
//         return "Enrollment deleted successfully";
//     }

//     public Page<Enrollment> paginated(int page,int size){
//         Pageable pageable=PageRequest.of(page,size,Sort.by("id").ascending());
//         return repository.findAll(pageable);
//     }

//     // public List<Enrollment> getEnrollmentsBy(Long userId) {
//     //     return repository.findByUser(userId);
//     // }
// }
