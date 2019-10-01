package com.tcs.bean;



import java.util.ArrayList;

public class Patient {
	private int patientId ;
	private String patientPassword ;
	private String FirstName ;
	private String LastName ;
	private String Gender ;
	private int Age ;
	private String Address ;
	private long ContactNumber ;
	private String Complaint ;
	private String Doctor ;
	private String InsuranceCover ;
	private long HealthInsuranceNumber ;
	private String yourbirthcity ;
	private String yourfavoriteactor;
	private String yourfavoritefood ;
	private String yourfavoritecrickter ;
	private String yourfavoritesport ;
	private String paymentStatus;
	private int hcpId;
	private ArrayList<Dependant>dependantlist= new ArrayList<Dependant>();

	
	
	


	public Patient(int patientId, String patientPassword, String firstName,
			String lastName, String gender, int age, String address,
			long contactNumber, String complaint, String doctor,
			String insuranceCover, long healthInsuranceNumber,
			String yourbirthcity, String yourfavoriteactor,
			String yourfavoritefood, String yourfavoritecrickter,
			String yourfavoritesport, int hcpId) {
		super();
		this.patientId = patientId;
		this.patientPassword = patientPassword;
		FirstName = firstName;
		LastName = lastName;
		Gender = gender;
		Age = age;
		Address = address;
		ContactNumber = contactNumber;
		Complaint = complaint;
		Doctor = doctor;
		InsuranceCover = insuranceCover;
		HealthInsuranceNumber = healthInsuranceNumber;
		this.yourbirthcity = yourbirthcity;
		this.yourfavoriteactor = yourfavoriteactor;
		this.yourfavoritefood = yourfavoritefood;
		this.yourfavoritecrickter = yourfavoritecrickter;
		this.yourfavoritesport = yourfavoritesport;
		this.hcpId = hcpId;
	}






	public Patient(String firstName, String lastName, String gender, int age,
			String address, long contactNumber, String complaint,
			String doctor, String insuranceCover, long healthInsuranceNumber,
			String yourbirthcity, String yourfavoriteactor,
			String yourfavoritefood, String yourfavoritecrickter,
			String yourfavoritesport, int hcpId) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Gender = gender;
		Age = age;
		Address = address;
		ContactNumber = contactNumber;
		Complaint = complaint;
		Doctor = doctor;
		InsuranceCover = insuranceCover;
		HealthInsuranceNumber = healthInsuranceNumber;
		this.yourbirthcity = yourbirthcity;
		this.yourfavoriteactor = yourfavoriteactor;
		this.yourfavoritefood = yourfavoritefood;
		this.yourfavoritecrickter = yourfavoritecrickter;
		this.yourfavoritesport = yourfavoritesport;
		this.hcpId = hcpId;
	}






	public Patient(String firstName, String lastName, String gender, int age,
			String address, long contactNumber, String complaint,
			String doctor, String insuranceCover, long healthInsuranceNumber,
			String yourbirthcity, String yourfavoriteactor,
			String yourfavoritefood, String yourfavoritecrickter,
			String yourfavoritesport, int hcpId,
			ArrayList<Dependant> dependantlist) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Gender = gender;
		Age = age;
		Address = address;
		ContactNumber = contactNumber;
		Complaint = complaint;
		Doctor = doctor;
		InsuranceCover = insuranceCover;
		HealthInsuranceNumber = healthInsuranceNumber;
		this.yourbirthcity = yourbirthcity;
		this.yourfavoriteactor = yourfavoriteactor;
		this.yourfavoritefood = yourfavoritefood;
		this.yourfavoritecrickter = yourfavoritecrickter;
		this.yourfavoritesport = yourfavoritesport;
		this.hcpId = hcpId;
		this.dependantlist = dependantlist;
	}






	public Patient(int patientId, String patientPassword, String firstName,
			String lastName, String gender, int age, String address,
			long contactNumber, String complaint, String doctor,
			String insuranceCover, long healthInsuranceNumber,
			String yourbirthcity, String yourfavoriteactor,
			String yourfavoritefood, String yourfavoritecrickter,
			String yourfavoritesport, int hcpId,
			ArrayList<Dependant> dependantlist) {
		super();
		this.patientId = patientId;
		this.patientPassword = patientPassword;
		FirstName = firstName;
		LastName = lastName;
		Gender = gender;
		Age = age;
		Address = address;
		ContactNumber = contactNumber;
		Complaint = complaint;
		Doctor = doctor;
		InsuranceCover = insuranceCover;
		HealthInsuranceNumber = healthInsuranceNumber;
		this.yourbirthcity = yourbirthcity;
		this.yourfavoriteactor = yourfavoriteactor;
		this.yourfavoritefood = yourfavoritefood;
		this.yourfavoritecrickter = yourfavoritecrickter;
		this.yourfavoritesport = yourfavoritesport;
		this.hcpId = hcpId;
		this.dependantlist = dependantlist;
	}






	public Patient(int patientId, String firstName, String address,
			long contactNumber, int hcpId) {
		super();
		this.patientId = patientId;
		FirstName = firstName;
		Address = address;
		ContactNumber = contactNumber;
		this.hcpId = hcpId;
	}






	public Patient(int patientId, String patientPassword, String firstName,
			String lastName) {
		super();
		this.patientId = patientId;
		this.patientPassword = patientPassword;
		FirstName = firstName;
		LastName = lastName;
	}



	


	public Patient(String firstName, String lastName, String gender, int age,
			String address, long contactNumber, String complaint,
			String doctor, String insuranceCover, long healthInsuranceNumber,
			String yourbirthcity, String yourfavoriteactor,
			String yourfavoritefood, String yourfavoritecrickter,
			String yourfavoritesport, String paymentStatus, int hcpId,
			ArrayList<Dependant> dependantlist) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Gender = gender;
		Age = age;
		Address = address;
		ContactNumber = contactNumber;
		Complaint = complaint;
		Doctor = doctor;
		InsuranceCover = insuranceCover;
		HealthInsuranceNumber = healthInsuranceNumber;
		this.yourbirthcity = yourbirthcity;
		this.yourfavoriteactor = yourfavoriteactor;
		this.yourfavoritefood = yourfavoritefood;
		this.yourfavoritecrickter = yourfavoritecrickter;
		this.yourfavoritesport = yourfavoritesport;
		this.paymentStatus = paymentStatus;
		this.hcpId = hcpId;
		this.dependantlist = dependantlist;
	}



	public Patient(int patientId, String patientPassword, String firstName,
			String lastName, String gender, int age, String address,
			long contactNumber, String complaint, String doctor,
			String insuranceCover, long healthInsuranceNumber,
			String yourbirthcity, String yourfavoriteactor,
			String yourfavoritefood, String yourfavoritecrickter,
			String yourfavoritesport, String paymentStatus, int hcpId,
			ArrayList<Dependant> dependantlist) {
		super();
		this.patientId = patientId;
		this.patientPassword = patientPassword;
		FirstName = firstName;
		LastName = lastName;
		Gender = gender;
		Age = age;
		Address = address;
		ContactNumber = contactNumber;
		Complaint = complaint;
		Doctor = doctor;
		InsuranceCover = insuranceCover;
		HealthInsuranceNumber = healthInsuranceNumber;
		this.yourbirthcity = yourbirthcity;
		this.yourfavoriteactor = yourfavoriteactor;
		this.yourfavoritefood = yourfavoritefood;
		this.yourfavoritecrickter = yourfavoritecrickter;
		this.yourfavoritesport = yourfavoritesport;
		this.paymentStatus = paymentStatus;
		this.hcpId = hcpId;
		this.dependantlist = dependantlist;
	}



	public Patient(int patientId, String firstName, String lastName,
			String gender, int age, String address, long contactNumber,
			long healthInsuranceNumber) {
		super();
		this.patientId = patientId;
		FirstName = firstName;
		LastName = lastName;
		Gender = gender;
		Age = age;
		Address = address;
		ContactNumber = contactNumber;
		HealthInsuranceNumber = healthInsuranceNumber;
	}

	
	



	public Patient(int patientId, String patientPassword, String firstName,
			String lastName, String gender, int age, String address,
			long contactNumber, String complaint, String doctor,
			String insuranceCover, long healthInsuranceNumber,
			String yourbirthcity, String yourfavoriteactor,
			String yourfavoritefood, String yourfavoritecrickter,
			String yourfavoritesport, String paymentStatus, int hcpId) {
		super();
		this.patientId = patientId;
		this.patientPassword = patientPassword;
		FirstName = firstName;
		LastName = lastName;
		Gender = gender;
		Age = age;
		Address = address;
		ContactNumber = contactNumber;
		Complaint = complaint;
		Doctor = doctor;
		InsuranceCover = insuranceCover;
		HealthInsuranceNumber = healthInsuranceNumber;
		this.yourbirthcity = yourbirthcity;
		this.yourfavoriteactor = yourfavoriteactor;
		this.yourfavoritefood = yourfavoritefood;
		this.yourfavoritecrickter = yourfavoritecrickter;
		this.yourfavoritesport = yourfavoritesport;
		this.paymentStatus = paymentStatus;
		this.hcpId = hcpId;
	}



	public Patient(String firstName, String lastName, String gender, int age,
			String address, long contactNumber, String complaint,
			String doctor, String insuranceCover, long healthInsuranceNumber,
			String yourbirthcity, String yourfavoriteactor,
			String yourfavoritefood, String yourfavoritecrickter,
			String yourfavoritesport, String paymentStatus, int hcpId) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Gender = gender;
		Age = age;
		Address = address;
		ContactNumber = contactNumber;
		Complaint = complaint;
		Doctor = doctor;
		InsuranceCover = insuranceCover;
		HealthInsuranceNumber = healthInsuranceNumber;
		this.yourbirthcity = yourbirthcity;
		this.yourfavoriteactor = yourfavoriteactor;
		this.yourfavoritefood = yourfavoritefood;
		this.yourfavoritecrickter = yourfavoritecrickter;
		this.yourfavoritesport = yourfavoritesport;
		this.paymentStatus = paymentStatus;
		this.hcpId = hcpId;
	}



	public Patient(String firstName, String lastName, String gender, int age,
			String address, long contactNumber, String complaint,
			String doctor, String insuranceCover, long healthInsuranceNumber,
			String yourbirthcity, String yourfavoriteactor,
			String yourfavoritefood, String yourfavoritecrickter,
			String yourfavoritesport) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Gender = gender;
		Age = age;
		Address = address;
		ContactNumber = contactNumber;
		Complaint = complaint;
		Doctor = doctor;
		InsuranceCover = insuranceCover;
		HealthInsuranceNumber = healthInsuranceNumber;
		this.yourbirthcity = yourbirthcity;
		this.yourfavoriteactor = yourfavoriteactor;
		this.yourfavoritefood = yourfavoritefood;
		this.yourfavoritecrickter = yourfavoritecrickter;
		this.yourfavoritesport = yourfavoritesport;
	}



	public Patient(int patientId, String patientPassword, String firstName,
			String lastName, String gender, int age, String address,
			long contactNumber, String complaint, String doctor,
			String insuranceCover, long healthInsuranceNumber) {
		super();
		this.patientId = patientId;
		this.patientPassword = patientPassword;
		FirstName = firstName;
		LastName = lastName;
		Gender = gender;
		Age = age;
		Address = address;
		ContactNumber = contactNumber;
		Complaint = complaint;
		Doctor = doctor;
		InsuranceCover = insuranceCover;
		HealthInsuranceNumber = healthInsuranceNumber;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getComplaint() {
		return Complaint;
	}

	public void setComplaint(String complaint) {
		Complaint = complaint;
	}

	public String getDoctor() {
		return Doctor;
	}

	public void setDoctor(String doctor) {
		Doctor = doctor;
	}



	public ArrayList<Dependant> getDependantlist() {
		return dependantlist;
	}



	public void setDependantlist(ArrayList<Dependant> dependantlist) {
		this.dependantlist = dependantlist;
	}



	public Patient(String firstName, String lastName, String gender, int age,
			String address, long contactNumber, String complaint,
			String doctor, String insuranceCover, long healthInsuranceNumber) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Gender = gender;
		Age = age;
		Address = address;
		ContactNumber = contactNumber;
		Complaint = complaint;
		Doctor = doctor;
		InsuranceCover = insuranceCover;
		HealthInsuranceNumber = healthInsuranceNumber;
	}
	

	public String getYourbirthcity() {
		return yourbirthcity;
	}



	public void setYourbirthcity(String yourbirthcity) {
		this.yourbirthcity = yourbirthcity;
	}



	public String getYourfavoriteactor() {
		return yourfavoriteactor;
	}



	public void setYourfavoriteactor(String yourfavoriteactor) {
		this.yourfavoriteactor = yourfavoriteactor;
	}



	public String getYourfavoritefood() {
		return yourfavoritefood;
	}



	public void setYourfavoritefood(String yourfavoritefood) {
		this.yourfavoritefood = yourfavoritefood;
	}



	public String getYourfavoritecrickter() {
		return yourfavoritecrickter;
	}



	public void setYourfavoritecrickter(String yourfavoritecrickter) {
		this.yourfavoritecrickter = yourfavoritecrickter;
	}



	public String getYourfavoritesport() {
		return yourfavoritesport;
	}



	public void setYourfavoritesport(String yourfavoritesport) {
		this.yourfavoritesport = yourfavoritesport;
	}



	public Patient() {
		super();
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientPassword() {
		return patientPassword;
	}
	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public long getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(long contactNumber) {
		ContactNumber = contactNumber;
	}
	public String getInsuranceCover() {
		return InsuranceCover;
	}
	public void setInsuranceCover(String insuranceCover) {
		InsuranceCover = insuranceCover;
	}
	public long getHealthInsuranceNumber() {
		return HealthInsuranceNumber;
	}
	public void setHealthInsuranceNumber(long healthInsuranceNumber) {
		HealthInsuranceNumber = healthInsuranceNumber;
	}



	public int getHcpId() {
		return hcpId;
	}



	public void setHcpId(int hcpId) {
		this.hcpId = hcpId;
	}



	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientPassword="
				+ patientPassword + ", FirstName=" + FirstName + ", LastName="
				+ LastName + ", Gender=" + Gender + ", Age=" + Age
				+ ", Address=" + Address + ", ContactNumber=" + ContactNumber
				+ ", Complaint=" + Complaint + ", Doctor=" + Doctor
				+ ", InsuranceCover=" + InsuranceCover
				+ ", HealthInsuranceNumber=" + HealthInsuranceNumber
				+ ", yourbirthcity=" + yourbirthcity + ", yourfavoriteactor="
				+ yourfavoriteactor + ", yourfavoritefood=" + yourfavoritefood
				+ ", yourfavoritecrickter=" + yourfavoritecrickter
				+ ", yourfavoritesport=" + yourfavoritesport + "]";
	}



	
	
}
