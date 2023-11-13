package com.hackunt.students.service;

import java.util.List;

import com.hackunt.students.dto.ReservationsDto;
import com.hackunt.students.entity.Reservations;

public interface ReservationsService {

	public void makeReservation(ReservationsDto reservationdto);

	public void updateReservation(Long reservation_id, Reservations reservation);

	public void deleteReservation(Long reservation_id);

	public Reservations getReservationById(Long reservation_id);

	public List<Reservations> getAllReservations();

}
