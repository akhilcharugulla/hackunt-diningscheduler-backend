package com.hackunt.students.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hackunt.students.entity.Dining;
import com.hackunt.students.repository.DiningRepository;

@Service
public class DiningServiceImpl implements DiningService {

    @Autowired
    DiningRepository diningRepository;

    public void addNewDiningTable(Dining dining) {
        diningRepository.save(dining);
    }

    public void updateTable(Long tableid, Dining dining) {
        Optional<Dining> existingDiningOptional = diningRepository.findById(tableid);

        if (existingDiningOptional.isPresent()) {
            Dining existingDining = existingDiningOptional.get();
            // Update the properties of the existing dining table with the new values
            existingDining.setLocation(dining.getLocation());
            existingDining.setTime(dining.getTime());
            diningRepository.save(existingDining);
        } else {
            throw new EntityNotFoundException("Dining table with ID " + tableid + " not found");
        }
    }

    public void deleteTable(Long tableid) {
        diningRepository.deleteById(tableid);
    }

    public Dining getTableById(Long tableid) {
        return diningRepository.findById(tableid).orElse(null);
    }

    public List<Dining> getAllTables() {
        return diningRepository.findAll();
    }

	@Override
    public List<Long> getTablesByAvailability(String availability) {
		List<Long> tableIds = diningRepository.findTableIdsByAvailability(availability);
		return tableIds;
    }

}
