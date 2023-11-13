package com.hackunt.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackunt.students.entity.Student;
import com.hackunt.students.service.StudentService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/students/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

    // Create a new student
    @PostMapping("/addstudent")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    // Update an existing student
    @PutMapping("/updatestudent/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }

    // Delete a student
    @DeleteMapping("/deletestudent/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    // Get details of a specific student
    @GetMapping("/getstudent/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    // Get a list of all students
    @GetMapping("/getallstudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
}

