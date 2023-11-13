package com.hackunt.students.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackunt.students.entity.Student;
import com.hackunt.students.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	public void updateStudent(Long id, Student student) {

		Optional<Student> existingStudentOptional = studentRepository.findById(id);

		if (existingStudentOptional.isPresent()) {
			Student existingStudent = existingStudentOptional.get();
			existingStudent.setName(student.getName());
			existingStudent.setEmail(student.getEmail());
			existingStudent.setMealplan(student.getMealplan());
			existingStudent.setPhone_no(student.getPhone_no());
			studentRepository.save(existingStudent);
		} else {
			throw new EntityNotFoundException("Student with ID " + id + " not found");
		}

	}

	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

}
