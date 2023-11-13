package com.hackunt.students.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackunt.students.dto.ReservationsDto;
import com.hackunt.students.entity.Dining;
import com.hackunt.students.entity.Menu;
import com.hackunt.students.entity.Reservations;
import com.hackunt.students.entity.Student;
import com.hackunt.students.repository.DiningRepository;
import com.hackunt.students.repository.MenuRepository;
import com.hackunt.students.repository.ReservationsRepository;
import com.hackunt.students.repository.StudentRepository;


@Service
public class ReservationsServiceImpl implements ReservationsService{

    @Autowired
    ReservationsRepository reservationsRepository;

	@Autowired
	MenuRepository menuRepository;

	@Autowired
	DiningRepository diningRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
    public void makeReservation(ReservationsDto reservationdto) {
    	Long itemid= reservationdto.getItemid();
    	Long studentid = reservationdto.getStudentid();
    	Long tableid = reservationdto.getTableid();

    	Menu menu = menuRepository.findById(itemid).get();
    	Student student = studentRepository.findById(studentid).get();
    	Dining dining = diningRepository.findById(tableid).get();
    	
    	Reservations reservations = new Reservations();
    	reservations.setDining(dining);
    	reservations.setMenu(menu);
    	reservations.setStudent(student);
        reservationsRepository.save(reservations);
    }

    public void updateReservation(Long reservation_id, Reservations reservation) {
		Optional<Reservations> existingReservationOptional = reservationsRepository.findById(reservation_id);
        if (existingReservationOptional.isPresent()) {
        Reservations existingReservation = existingReservationOptional.get();
        reservationsRepository.save(existingReservation);
    } else {
        throw new EntityNotFoundException("Reservation with ID " + reservation_id + " not found");
    }

    }

    public void deleteReservation(Long reservation_id) {
        reservationsRepository.deleteById(reservation_id);
    }

    public Reservations getReservationById(Long reservation_id) {
        return reservationsRepository.findById(reservation_id).orElse(null);
    }

    public List<Reservations> getAllReservations() {
        return reservationsRepository.findAll();
    }

}

