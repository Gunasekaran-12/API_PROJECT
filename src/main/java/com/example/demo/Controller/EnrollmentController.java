package com.example.demo.Controller;
import com.example.demo.entities.Enrollment;
import com.example.demo.services.Enrollmentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    Enrollmentservice service;
    @Autowired
    EnrollmentController(Enrollmentservice es)
    {
        service=es;
    }

    @PostMapping
    public Enrollment enrollInCourse(@RequestBody Enrollment enrollment) {
        return service.enrollInCourse(enrollment);
    }
    @GetMapping
    public Optional<Enrollment> getEnrollmentsByUserId() {
        return service.getEnrollmentsByUserId(null);
    }

    @PutMapping("/{id}")
    public Enrollment updateEnrollmentProgress(@PathVariable Long id, @RequestBody Enrollment updatedEnrollment) {
        return service.updateEnrollmentProgress(id, updatedEnrollment);
    }

    @DeleteMapping("/{id}")
    public String deleteEnrollment(@PathVariable Long id) {
        return service.deleteEnrollment(id);
    }

     @GetMapping("/pag")
    public Page<Enrollment>paginated(@RequestParam int page,@RequestParam int size)
    {
        return service.paginated(page,size);
    }
    
    // @GetMapping("/user/{userId}")
    // public List<Enrollment> getEnrollmentsBy(@PathVariable Long userId) {
    //     return service.getEnrollmentsBy(userId);
    // }
}
// @ManyToMany (cascade=CascadeType.ALL)
// @JoinTable(
//     name="student_course",
//     joinColumns=@JoinColumn(name="student_id"),
//     inverseJoinColumn=@JoinColumn(name="course_id"))
//     Set<Course>courses=new HashSet<>();