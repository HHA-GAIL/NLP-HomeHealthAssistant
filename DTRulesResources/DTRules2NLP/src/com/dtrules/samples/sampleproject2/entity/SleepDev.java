package com.dtrules.samples.sampleproject2.entity;

import java.util.Date;

public class SleepDev {

	public static int id_counter = 1;
	public int id;
	
	public int sleepMeasurement;
	public Date sleepDate;
	public String sleepID;
	
	public SleepDev(){
		this.id = id_counter++;
	}

	public int getId() {
		return id;
	}

	public int getSleepMeasurement() {
		return sleepMeasurement;
	}

	public void setSleepMeasurement(int sleepMeasurement) {
		this.sleepMeasurement = sleepMeasurement;
	}

	public Date getSleepDate() {
		return sleepDate;
	}

	public void setSleepDate(Date sleepDate) {
		this.sleepDate = sleepDate;
	}

	public String getSleepID() {
		return sleepID;
	}

	public void setSleepID(String sleepID) {
		this.sleepID = sleepID;
	}
	
	
	
}
