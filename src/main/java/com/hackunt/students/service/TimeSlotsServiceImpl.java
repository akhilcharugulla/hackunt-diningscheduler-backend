package com.hackunt.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackunt.students.dto.TimeSlotsDto;
import com.hackunt.students.entity.Dining;
import com.hackunt.students.entity.TimeSlots;
import com.hackunt.students.repository.DiningRepository;
import com.hackunt.students.repository.TimeSlotsRepository;

@Service
public class TimeSlotsServiceImpl implements TimeSlotsService{ 
    @Autowired
    private TimeSlotsRepository timeslotsRepository;

    @Autowired
    private DiningRepository diningRepository;

    public TimeSlots createTimeSlots(TimeSlotsDto timeSlotsDto) {
    	
    	Long tableId = timeSlotsDto.getTableid();
    	
    	Dining dining = diningRepository.findById(tableId).get();

    	TimeSlots timeSlots = new TimeSlots();
    	
    	timeSlots.setBookedtableno(dining);
    	timeSlots.setSlotPeriodForOneHour(timeSlotsDto.getSlotPeriodForOneHour());
    	timeSlots.setTimeAvailability(timeSlotsDto.getTimeAvailability());
        return timeslotsRepository.save(timeSlots);
    }

	public List<TimeSlots> getAllTimeSlots() {
        return timeslotsRepository.findAll();
    }

    public TimeSlots getTimeSlotsById(Long id) {
        return timeslotsRepository.findById(id).orElse(null);
    }

    public TimeSlots updateTimeSlots(Long id, TimeSlots updatedTimeslot) {
        TimeSlots existingTimeslot = timeslotsRepository.findById(id).orElse(null);

        if (existingTimeslot != null) {

        	existingTimeslot.setSlotPeriodForOneHour(updatedTimeslot.getSlotPeriodForOneHour()); 
        	existingTimeslot.setTimeAvailability(updatedTimeslot.getTimeAvailability()); 
            return timeslotsRepository.save(existingTimeslot);
        }
        return null;
    }

    public void deleteTimeSlots(Long id) {
    	timeslotsRepository.deleteById(id);
    }

	public List<String> getTimeslotsForTable(Long tableid){
		return timeslotsRepository.findTimeSlotsForTable(tableid);
	}

}
