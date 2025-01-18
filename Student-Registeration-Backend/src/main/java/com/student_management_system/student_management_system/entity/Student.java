package com.student_management_system.student_management_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNo;
    @Column(name = "student_name")
    private String name;
    @Column(name="student_percentage")
    private float percentage;
    @Column(name="student_branch")
    private String branch;

    public Student() {
        // TODO Auto-generated constructor stub
    }


    public Student(String name, float percentage, String branch) {
        super();
        this.name = name;
        this.percentage = percentage;
        this.branch = branch;
    }


    @Override
    public String toString() {
        return "Student [rollNo=" + rollNo + ", name=" + name + ", percentage=" + percentage + ", branch=" + branch
                + "]";
    }



}
