package com.hackunt.students.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Menu {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemid;    
    private Double price;
    private String availability;
    private String itemname;
    private String itemcattype;

	@OneToMany(mappedBy = "menu", cascade=CascadeType.ALL)
    private List<Reservations> reservations;

    
    public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getItemcattype() {
		return itemcattype;
	}
	public void setItemcattype(String itemcattype) {
		this.itemcattype = itemcattype;
	}
	
}
