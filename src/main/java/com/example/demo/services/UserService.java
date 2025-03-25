package com.example.demo.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Enrollment;
import com.example.demo.entities.LearningGoal;
import com.example.demo.entities.User;

import jakarta.transaction.Transactional;
@Service
public class UserService {
    @Autowired
    private com.example.demo.repositories.UserRepository rep;
    // public User addUser(User u)
    // {
    //     return rep.save(u);
    // }
     

    @Transactional
    public User addUser(User user) {
        for (Enrollment enrollment : user.getEnrolledCourses()) { 
            enrollment.setUser(user);
        }
        for (LearningGoal goal : user.getLearningGoals()) {
            goal.setUser(user);
        }
    
        return rep.save(user);
    }

    public List<User> getUser()
    {
        return rep.findAll();
    }
    public User updatebyid(Long id,User user)
    {
        user.setId(id);
        return rep.save(user);
    }
    @Transactional
    public String deleteusersbyid(Long id)
    {
        rep.deleteById(id);
        return "User deleted successfully";
    }
    public Page<User> paginated(int page,int size){
    Pageable pageable=PageRequest.of(page,size,Sort.by(Sort.Order.asc("id")));
       //Pageable pageable=PageRequest.of(page,size,Sort.by("name").ascending());
        return rep.findAll(pageable);
    }
    
    public Optional<User> getUserByEmail(String email) {
        return Optional.empty();
    }
    
    public User getUserWithCourses(Long id) {
        return rep.findByIdWithCourses(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    //Using Map Getting Individual Attributes
    // public List<String>getAllUserByEmail(){
    //     return rep.findAll().stream()
    //     .map(User::getEmail)
    //     .collect(Collectors.toList());
    // }
}
