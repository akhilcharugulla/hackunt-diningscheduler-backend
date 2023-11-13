package com.hackunt.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackunt.students.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
