package com.kkg.rest.test;

public class Employee {

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setAddress(Address adr1) {
		this.adr1 = adr1;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public Address getAddress() {
		return adr1;
	}

	int id;
	String name;
	String email;
	String phoneNumber;
	
	Address adr1;
	
}
