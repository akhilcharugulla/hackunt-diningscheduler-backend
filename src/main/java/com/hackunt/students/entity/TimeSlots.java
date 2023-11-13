package com.hackunt.students.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TimeSlots {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timeId;    
    private String slotPeriodForOneHour;
    private String timeAvailability;
    @ManyToOne
    private Dining bookedtableno;
    
	public String getSlotPeriodForOneHour() {
		return slotPeriodForOneHour;
	}
	public void setSlotPeriodForOneHour(String slotPeriodForOneHour) {
		this.slotPeriodForOneHour = slotPeriodForOneHour;
	}
	public String getTimeAvailability() {
		return timeAvailability;
	}
	public void setTimeAvailability(String timeAvailability) {
		this.timeAvailability = timeAvailability;
	}
	public Dining getBookedtableno() {
		return bookedtableno;
	}
	public void setBookedtableno(Dining bookedtableno) {
		this.bookedtableno = bookedtableno;
	}
    
    
}
