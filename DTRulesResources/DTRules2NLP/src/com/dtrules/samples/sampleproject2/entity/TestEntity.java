package com.dtrules.samples.sampleproject2.entity;

public class TestEntity {
	
	public static int id_counter = 1;
	public int id;
	
	public int testID;
	public String test_Name;
	
	public TestEntity(){
		this.id = id_counter++;
		this.testID = 0;
		this.test_Name = "";
	}

	public int getId() {
		return id;
	}

	public int getTestID() {
		return testID;
	}

	public void setTestID(int testID) {
		this.testID = testID;
	}

	public String getTestName() {
		return test_Name;
	}

	public void setTestName(String testName) {
		this.test_Name = testName;
	}
	
	

}
