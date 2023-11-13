package com.hackunt.students.dto;

public class TimeSlotsDto {

    private String SlotPeriodForOneHour;
    private String timeAvailability;
    private Long tableid;
    
	public String getSlotPeriodForOneHour() {
		return SlotPeriodForOneHour;
	}
	public void setSlotPeriodForOneHour(String slotPeriodForOneHour) {
		SlotPeriodForOneHour = slotPeriodForOneHour;
	}
	public String getTimeAvailability() {
		return timeAvailability;
	}
	public void setTimeAvailability(String timeAvailability) {
		this.timeAvailability = timeAvailability;
	}
	public Long getTableid() {
		return tableid;
	}
	public void setTableid(Long tableid) {
		this.tableid = tableid;
	}

}
