package com.hackunt.students.service;

import java.util.List;

import com.hackunt.students.entity.Dining;

public interface DiningService {

	void addNewDiningTable(Dining dining);

	void updateTable(Long tableid, Dining dining);

	void deleteTable(Long tableid);

	Dining getTableById(Long tableid);

	List<Dining> getAllTables();

    public List<Long> getTablesByAvailability(String availability);
}
