package com.hackunt.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackunt.students.entity.Reservations;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservations, Long>{

}
