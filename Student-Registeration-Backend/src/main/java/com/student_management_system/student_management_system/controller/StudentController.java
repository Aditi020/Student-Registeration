package com.student_management_system.student_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.student_management_system.student_management_system.entity.Student;
import com.student_management_system.student_management_system.repository.StudentRepository;

@RestController
public class StudentController {

    @Autowired
    StudentRepository repo;

    // Root endpoint (home page)
    @GetMapping("/")
    public String home() {
        return "Welcome to the Student Management System!";
    }

    // Get all the students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // Get a student by ID
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        Student student = repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        return ResponseEntity.ok(student);
    }

    // Create a new student
    @PostMapping("/students/add")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student newStudent = repo.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }

    // Update an existing student
    @PutMapping("/students/update/{id}")
    @Transactional
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        Student student = repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));

        // Update student details
        student.setName(updatedStudent.getName());
        student.setPercentage(updatedStudent.getPercentage());
        student.setBranch(updatedStudent.getBranch());

        // The `@Transactional` annotation will handle saving the updated entity automatically.
        return ResponseEntity.ok(student);
    }

    // Delete a student by ID
    @DeleteMapping("/students/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Transactional
    public void removeStudent(@PathVariable int id) {
        Student student = repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        repo.delete(student);
    }
}
