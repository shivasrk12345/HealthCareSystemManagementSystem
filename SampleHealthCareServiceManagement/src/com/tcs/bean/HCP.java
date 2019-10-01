package com.tcs.bean;

public class HCP {

	
	private int hcpID;
	private String password;
	private String hcpName;
	private String licenseNumber;
	private String address;
	private long contactNumber;
	private long alernateContactnumber;
	private String email;
	
	private String question1;
	private String answer1;
	private String question2;
	
	private String answer2;
	
	
	
	
	public HCP(int hcpID, String hcpName, String address, long contactNumber,
			long alernateContactnumber, String email) {
		super();
		this.hcpID = hcpID;
		this.hcpName = hcpName;
		this.address = address;
		this.contactNumber = contactNumber;
		this.alernateContactnumber = alernateContactnumber;
		this.email = email;
	}




	public HCP() {
		super();
		// TODO Auto-generated constructor stub
	}




	public HCP(int hcpID, String password, String hcpName) {
		super();
		this.hcpID = hcpID;
		this.password = password;
		this.hcpName = hcpName;
	}




	public HCP(int hcpID, String password) {
		super();
		this.hcpID = hcpID;
		this.password = password;
	}




	public HCP(int hcpID, String password, String hcpName,
			String licenseNumber, String address, long contactNumber,
			long alernateContactnumber, String email, String question1,
			String answer1, String question2, String answer2) {
		super();
		this.hcpID = hcpID;
		this.password = password;
		this.hcpName = hcpName;
		this.licenseNumber = licenseNumber;
		this.address = address;
		this.contactNumber = contactNumber;
		this.alernateContactnumber = alernateContactnumber;
		this.email = email;
		this.question1 = question1;
		this.answer1 = answer1;
		this.question2 = question2;
		this.answer2 = answer2;
	}




	public HCP(String hcpName, String licenseNumber, String address,
			long contactNumber, long alernateContactnumber, String email,
			String question1, String answer1, String question2, String answer2) {
		super();
		this.hcpName = hcpName;
		this.licenseNumber = licenseNumber;
		this.address = address;
		this.contactNumber = contactNumber;
		this.alernateContactnumber = alernateContactnumber;
		this.email = email;
		this.question1 = question1;
		this.answer1 = answer1;
		this.question2 = question2;
		this.answer2 = answer2;
	}




	public int getHcpID() {
		return hcpID;
	}




	public void setHcpID(int hcpID) {
		this.hcpID = hcpID;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getHcpName() {
		return hcpName;
	}




	public void setHcpName(String hcpName) {
		this.hcpName = hcpName;
	}




	public String getLicenseNumber() {
		return licenseNumber;
	}




	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
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




	public long getAlernateContactnumber() {
		return alernateContactnumber;
	}




	public void setAlernateContactnumber(long alernateContactnumber) {
		this.alernateContactnumber = alernateContactnumber;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getQuestion1() {
		return question1;
	}




	public void setQuestion1(String question1) {
		this.question1 = question1;
	}




	public String getAnswer1() {
		return answer1;
	}




	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}




	public String getQuestion2() {
		return question2;
	}




	public void setQuestion2(String question2) {
		this.question2 = question2;
	}




	public String getAnswer2() {
		return answer2;
	}




	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}




	@Override
	public String toString() {
		return "HCP [hcpID=" + hcpID + ", password=" + password + ", hcpName="
				+ hcpName + ", licenseNumber=" + licenseNumber + ", address="
				+ address + ", contactNumber=" + contactNumber
				+ ", alernateContactnumber=" + alernateContactnumber
				+ ", email=" + email + ", question1=" + question1
				+ ", answer1=" + answer1 + ", question2=" + question2
				+ ", answer2=" + answer2 + "]";
	}




	

	
	
	
}
