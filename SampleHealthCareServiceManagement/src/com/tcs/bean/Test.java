package com.tcs.bean;

public class Test {
	
	private int labId;
	private String testName;
	private String testCode;
	private String testDesc;
	private String duration;
	private double cost;
	private String labAtHome;
	
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Test(int labId, String testName, String testCode, String testDesc,
			String duration, double cost, String labAtHome) {
		super();
		this.labId = labId;
		this.testName = testName;
		this.testCode = testCode;
		this.testDesc = testDesc;
		this.duration = duration;
		this.cost = cost;
		this.labAtHome = labAtHome;
	}

	public int getLabId() {
		return labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestCode() {
		return testCode;
	}

	public void setTestCode(String testCode) {
		this.testCode = testCode;
	}

	public String getTestDesc() {
		return testDesc;
	}

	public void setTestDesc(String testDesc) {
		this.testDesc = testDesc;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getLabAtHome() {
		return labAtHome;
	}

	public void setLabAtHome(String labAtHome) {
		this.labAtHome = labAtHome;
	}
	
	public String toString()
	{
		return testName+" "+testCode+" "+testDesc+" "+duration+" "+cost+" "+labAtHome;
	}
}
