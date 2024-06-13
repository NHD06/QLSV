package com.example.qlsv.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

// Model tương ứng với bảng students trong CSDL
@Entity
@Table(name = "students")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_code", nullable = false, unique = true)
    private String studentCode;

    @Column(name = "fullname",nullable = false)
    private String fullname;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "entry_date")
    private Date entryDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private AppUser user;
    
    @Column(name = "gender")
    private Integer gender;

    @Column(name = "status")
    private String status;

    @Column(name = "profile_code")
    private String profileCode;

    @Column(name = "class_code")
    private String classCode;

    @Column(name = "education_level")
    private String educationLevel;

    @Column(name = "major")
    private String major;

    @Column(name = "course")
    private String course;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "target_group")
    private String targetGroup;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "account_holder_name")
    private String accountHolderName;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @Column(name = "advisor_name")
    private String advisorName;

    @Column(name = "advisor_phone")
    private String advisorPhone;

    @Column(name = "advisor_email")
    private String advisorEmail;
    
    // Constructors, Getters and Setters
    

    public Student(Long id, String studentCode, String fullname, String email, String phoneNumber, String address,
            Department department, Date entryDate, AppUser user, Integer gender, String status, String profileCode,
            String classCode, String educationLevel, String major, String course, Date dateOfBirth, String targetGroup,
            String birthPlace, String bankName, String accountHolderName, String bankAccountNumber, String advisorName,
            String advisorPhone, String advisorEmail) {
        this.id = id;
        this.studentCode = studentCode;
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.department = department;
        this.entryDate = entryDate;
        this.user = user;
        this.gender = gender;
        this.status = status;
        this.profileCode = profileCode;
        this.classCode = classCode;
        this.educationLevel = educationLevel;
        this.major = major;
        this.course = course;
        this.dateOfBirth = dateOfBirth;
        this.targetGroup = targetGroup;
        this.birthPlace = birthPlace;
        this.bankName = bankName;
        this.accountHolderName = accountHolderName;
        this.bankAccountNumber = bankAccountNumber;
        this.advisorName = advisorName;
        this.advisorPhone = advisorPhone;
        this.advisorEmail = advisorEmail;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProfileCode() {
        return profileCode;
    }

    public void setProfileCode(String profileCode) {
        this.profileCode = profileCode;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTargetGroup() {
        return targetGroup;
    }

    public void setTargetGroup(String targetGroup) {
        this.targetGroup = targetGroup;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    public String getAdvisorPhone() {
        return advisorPhone;
    }

    public void setAdvisorPhone(String advisorPhone) {
        this.advisorPhone = advisorPhone;
    }

    public String getAdvisorEmail() {
        return advisorEmail;
    }

    public void setAdvisorEmail(String advisorEmail) {
        this.advisorEmail = advisorEmail;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }
}
