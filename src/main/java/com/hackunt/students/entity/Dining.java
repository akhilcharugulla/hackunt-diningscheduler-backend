package com.hackunt.students.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Dining {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableid;
    private LocalDateTime time;
    private String location;
    private String tableAvailability;

	@OneToMany(mappedBy = "dining", cascade=CascadeType.ALL)
    private List<Reservations> reservs;

	@OneToMany(mappedBy = "bookedtableno", cascade = CascadeType.ALL)
	private List<TimeSlots> timeslots;
	
    public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTableAvailability() {
		return tableAvailability;
	}

	public void setTableAvailability(String tableAvailability) {
		this.tableAvailability = tableAvailability;
	}

	public Long getTableid() {
		return tableid;
	}

}
