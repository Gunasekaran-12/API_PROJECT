package com.example.demo.entities;
import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LearningGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String goalName;
    private Date targetCompletionDate;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    public LearningGoal(){

    }
     
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public Date getTargetCompletionDate() {
        return targetCompletionDate;
    }

    public void setTargetCompletionDate(Date targetCompletionDate) {
        this.targetCompletionDate = targetCompletionDate;
    }


    public LearningGoal(Long id, String goalName, Date targetCompletionDate, User user) {
        this.id = id;
        this.goalName = goalName;
        this.targetCompletionDate = targetCompletionDate;
        this.user = user;
    }
    
    

    // public User getUser() {
    //     return user;
    // }

    // public void setUser(User user) {
    //     this.user = user;
    // }

    // public LearningGoal() {
        
    // }

    // public LearningGoal(Long id, String goalName, Date targetCompletionDate) {
    //     this.id = id;
    //     this.goalName = goalName;
    //     this.targetCompletionDate = targetCompletionDate;
    // }

    // public Long getId() {
    //     return id;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    // public String getGoalName() {
    //     return goalName;
    // }

    // public void setGoalName(String goalName) {
    //     this.goalName = goalName;
    // }

    // public Date getTargetCompletionDate() {
    //     return targetCompletionDate;
    // }

    // public void setTargetCompletionDate(Date targetCompletionDate) {
    //     this.targetCompletionDate = targetCompletionDate;
    // }
}
