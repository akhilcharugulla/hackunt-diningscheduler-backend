package com.hackunt.students.service;

import java.util.List;

import com.hackunt.students.entity.Student;

public interface StudentService {

	void addStudent(Student student);

	void updateStudent(Long id, Student student);

	void deleteStudent(Long id);

	Student getStudentById(Long id);

	List<Student> getAllStudents();

}
