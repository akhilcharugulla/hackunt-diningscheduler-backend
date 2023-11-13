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

import com.hackunt.students.dto.ReservationsDto;
import com.hackunt.students.entity.Reservations;
import com.hackunt.students.service.ReservationsService;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/reservations/v1")
public class ReservationController {

    @Autowired
    ReservationsService reservationService;

    // Create a new reservation
    @PostMapping("/addreservation")
    public void makeReservation(@RequestBody ReservationsDto reservationdto) {	
        reservationService.makeReservation(reservationdto);
    }

    // Update an existing reservation
    @PutMapping("/updatereservation/{reservation_id}")
    public void updateReservation(@PathVariable Long reservation_id, @RequestBody Reservations reservation) {
        reservationService.updateReservation(reservation_id, reservation);
    }

    // Delete a reservation
    @DeleteMapping("/deletereservation/{reservation_id}")
    public void deleteReservation(@PathVariable Long reservation_id) {
        reservationService.deleteReservation(reservation_id);
    }

    // Get details of a specific reservation
    @GetMapping("/getreservation/{reservation_id}")
    public ResponseEntity<Reservations> getReservationById(@PathVariable Long reservation_id) {
        Reservations reservation = reservationService.getReservationById(reservation_id);
        return ResponseEntity.ok(reservation);
    }

    // Get a list of all reservations
    @GetMapping("/getallreservations")
    public ResponseEntity<List<Reservations>> getAllReservations() {
        List<Reservations> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }
}

