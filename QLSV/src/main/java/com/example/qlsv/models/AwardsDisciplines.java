package com.example.qlsv.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
// Model tương ứng với bảng awards_disciplines trong CSDL
@Entity
@Table(name = "awards_disciplines")
public class AwardsDisciplines {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    
    @Column(nullable = false)
    private Boolean type;
    
    @Column(nullable = false)
    private String level;
    
    @Column(nullable = false)
    private String description;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String rewardType;

    public AwardsDisciplines() {
    }

    public AwardsDisciplines(Long id, Student student, Boolean type, String level, String description, Date date, String rewardType) {
        this.id = id;
        this.student = student;
        this.type = type;
        this.level = level;
        this.description = description;
        this.date = date;
        this.rewardType = rewardType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Boolean  getType() {
        return type;
    }

    public void setType(Boolean  type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRewardType() {
        return rewardType;
    }

    public void setRewardType(String rewardType) {
        this.rewardType = rewardType;
    }

    // Getters and setters
    
}
