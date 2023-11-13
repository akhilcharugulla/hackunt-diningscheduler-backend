package com.hackunt.students.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentid;
    private String name;
    private String email;
    private String mealplan;
    private String phone_no;
    private String euid;
    private String encryptedpwd;
    
	public String getEuid() {
		return euid;
	}

	public void setEuid(String euid) {
		this.euid = euid;
	}

	public String getEncryptedpwd() {
		return encryptedpwd;
	}

	public void setEncryptedpwd(String encryptedpwd) {
		this.encryptedpwd = encryptedpwd;
	}

	//@OneToOne(cascade=CascadeType.ALL)
	@OneToOne(mappedBy = "student", cascade=CascadeType.ALL)
    private Reservations reservations;
	
    
    public Reservations getReservations() {
		return reservations;
	}

	public void setReservations(Reservations reservations) {
		this.reservations = reservations;
	}

	public String getName() {
		return name;
	}

	public Long getStudentid() {
		return studentid;
	}

	public void setStudentid(Long studentid) {
		this.studentid = studentid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMealplan() {
		return mealplan;
	}

	public void setMealplan(String mealplan) {
		this.mealplan = mealplan;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

}
