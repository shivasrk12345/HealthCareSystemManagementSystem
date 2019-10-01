package com.tcs.bean;



public class Dependant {
private int patientId;
private String Name;
private String relationship;
private String gender;
private int age;
private String address;
private long contactNumber;
private String insuranceCover;
private long healthInsuranceNumber;
public Dependant(int patientId, String name, String relationship,
		String gender, int age, String address, long contactNumber,
		String insuranceCover, long healthInsuranceNumber) {
	super();
	this.patientId = patientId;
	Name = name;
	this.relationship = relationship;
	this.gender = gender;
	this.age = age;
	this.address = address;
	this.contactNumber = contactNumber;
	this.insuranceCover = insuranceCover;
	this.healthInsuranceNumber = healthInsuranceNumber;
}
public Dependant(String name, String relationship, String gender, int age,
		String address, long contactNumber, String insuranceCover,
		long healthInsuranceNumber) {
	super();
	Name = name;
	this.relationship = relationship;
	this.gender = gender;
	this.age = age;
	this.address = address;
	this.contactNumber = contactNumber;
	this.insuranceCover = insuranceCover;
	this.healthInsuranceNumber = healthInsuranceNumber;
}

public Dependant(String name, String relationship, String address,
		long contactNumber) {
	super();
	Name = name;
	this.relationship = relationship;
	this.address = address;
	this.contactNumber = contactNumber;
}
public int getPatientId() {
	return patientId;
}
public void setPatientId(int patientId) {
	this.patientId = patientId;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getRelationship() {
	return relationship;
}
public void setRelationship(String relationship) {
	this.relationship = relationship;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long getContactNumber() {
	return contactNumber;
}
public void setContactNumber(long contactNumber) {
	this.contactNumber = contactNumber;
}
public String getInsuranceCover() {
	return insuranceCover;
}
public void setInsuranceCover(String insuranceCover) {
	this.insuranceCover = insuranceCover;
}
public long getHealthInsuranceNumber() {
	return healthInsuranceNumber;
}
public void setHealthInsuranceNumber(long healthInsuranceNumber) {
	this.healthInsuranceNumber = healthInsuranceNumber;
}





}
