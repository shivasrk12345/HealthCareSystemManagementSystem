package com.tcs.bean;

import java.util.ArrayList;

public class LSP {

	private int labId;
	private String LSPName;
	private String Address;
	private int zipcode;
	private String state;
	private String city;
	
	private ArrayList<Test> test=new ArrayList<Test>();

	public LSP() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LSP(int labId, String lSPName, String address, int zipcode,
			String state, String city, ArrayList<Test> test) {
		super();
		this.labId = labId;
		LSPName = lSPName;
		Address = address;
		this.zipcode = zipcode;
		this.state = state;
		this.city = city;
		this.test = test;
	}

	public int getLabId() {
		return labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
	}

	public String getLSPName() {
		return LSPName;
	}

	public void setLSPName(String lSPName) {
		LSPName = lSPName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public ArrayList<Test> getTest() {
		return test;
	}

	public void setTest(ArrayList<Test> test) {
		this.test = test;
	}
	
	public String toString()
	{
		return LSPName+" "+Address+" "+zipcode+" "+state+" "+city;
	}
}
