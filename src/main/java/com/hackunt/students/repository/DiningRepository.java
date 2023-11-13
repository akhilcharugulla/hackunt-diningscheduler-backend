package com.hackunt.students.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hackunt.students.entity.Dining;

@Repository
public interface DiningRepository extends JpaRepository<Dining, Long> {

	@Query("SELECT d.tableid FROM Dining d WHERE d.tableAvailability = :availability")
	List<Long> findTableIdsByAvailability(@Param("availability") String availability);

}