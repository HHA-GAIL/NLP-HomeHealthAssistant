package com.dtrules.samples.sampleproject2.entity;

import java.util.Date;

public class StepsDev {

	public static int id_counter = 1;
	public int id;
	
	public int stepsMeasurement;
	public Date stepsDate;
	public String stepsID;
	
	public StepsDev(){
		this.id = id_counter++;
	}

	public int getId() {
		return id;
	}

	public int getStepsMeasurement() {
		return stepsMeasurement;
	}

	public void setStepsMeasurement(int stepsMeasurement) {
		this.stepsMeasurement = stepsMeasurement;
	}

	public Date getStepsDate() {
		return stepsDate;
	}

	public void setStepsDate(Date stepsDate) {
		this.stepsDate = stepsDate;
	}

	public String getStepsID() {
		return stepsID;
	}

	public void setStepsID(String stepsID) {
		this.stepsID = stepsID;
	}
	
	
	
}
