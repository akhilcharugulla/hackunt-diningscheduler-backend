package com.hackunt.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackunt.students.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

}
