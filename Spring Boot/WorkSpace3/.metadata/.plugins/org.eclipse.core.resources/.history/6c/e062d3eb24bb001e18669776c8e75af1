package com.model;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private int empId;
    private String empName;
    private double salary;
    private String gender;
    private Date doj;
    private String country;
    private String emailId;
    private String password;

    // Implementing Mapping Between Employee and Department
    @ManyToOne
    @JoinColumn(name = "deptId")
    Department department;

    public Employee() {
    }

    // Parameterized Constructor without empId
    public Employee(String empName, double salary, String gender, Date doj, String country, String emailId,
            String password) {
        this.empName = empName;
        this.salary = salary;
        this.gender = gender;
        this.doj = doj;
        this.country = country;
        this.emailId = emailId;
        this.password = hashPassword(password);
    }

    public Employee(int empId, String empName, double salary, String gender, Date doj, String country, String emailId,
            String password) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.gender = gender;
        this.doj = doj;
        this.country = country;
        this.emailId = emailId;
        this.password = hashPassword(password);
    }

    // Generating Getter for department Variable
    public Department getDepartment() {
        return department;
    }

    // Generating Setter for department Variable
    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    public boolean checkPassword(String candidatePassword) {
        return BCrypt.checkpw(candidatePassword, this.password);
    }

    // Hash the password using BCrypt
    private String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }
}