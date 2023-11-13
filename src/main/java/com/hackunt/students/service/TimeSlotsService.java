package com.hackunt.students.service;

import java.util.List;

import com.hackunt.students.dto.TimeSlotsDto;
import com.hackunt.students.entity.TimeSlots;

public interface TimeSlotsService {

	List<TimeSlots> getAllTimeSlots();

	TimeSlots getTimeSlotsById(Long id);

	TimeSlots createTimeSlots(TimeSlotsDto timeSlotsDto);

	TimeSlots updateTimeSlots(Long id, TimeSlots updatedTimeSlots);

	void deleteTimeSlots(Long id);

	List<String> getTimeslotsForTable(Long tableid);

}
