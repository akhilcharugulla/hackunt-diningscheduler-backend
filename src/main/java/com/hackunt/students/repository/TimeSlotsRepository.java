package com.hackunt.students.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hackunt.students.entity.TimeSlots;

@Repository
public interface TimeSlotsRepository extends JpaRepository<TimeSlots,Long>{
	
    @Query("SELECT ts.slotPeriodForOneHour FROM TimeSlots ts WHERE ts.bookedtableno.tableid = :tableId AND ts.timeAvailability = 'yes'")
	List<String> findTimeSlotsForTable(@Param("tableId") Long tableId);

}
