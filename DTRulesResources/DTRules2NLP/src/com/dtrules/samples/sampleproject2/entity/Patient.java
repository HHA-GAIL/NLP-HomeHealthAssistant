package com.dtrules.samples.sampleproject2.entity;

import java.util.ArrayList;
import java.util.List;

public class Patient {

	public static int id_counter = 1;
	public int id;
	public static String FEMALE = "female";
	public static String MALE = "male";
	
	public String patient_ID;
	public String patientName;
	public String gender;
	public Result patientResult;
	public List<SleepDev> sleepDevs = new ArrayList<SleepDev>();
	public List<StepsDev> stepsDevs = new ArrayList<StepsDev>();
	public CalculateSLD calculateSLD;
	public CalculateSTD calculateSTD;
	public TestEntity myTestEntity;
	
	public Patient(){
		this.id = id_counter++;
	}
	
	public int getId() {
		return id;
	}

	public String getPatient_ID() {
		return patient_ID;
	}
	public void setPatient_ID(String patient_ID) {
		this.patient_ID = patient_ID;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Result getPatientResult() {
		return patientResult;
	}
	public void setPatientResult(Result patientResult) {
		this.patientResult = patientResult;
	}
	public List<SleepDev> getSleepDevs() {
		return sleepDevs;
	}
	public void setSleepDevs(List<SleepDev> sleepDevs) {
		this.sleepDevs = sleepDevs;
	}
	public List<StepsDev> getStepsDevs() {
		return stepsDevs;
	}
	public void setStepsDevs(List<StepsDev> stepsDevs) {
		this.stepsDevs = stepsDevs;
	}
	public CalculateSLD getCalculateSLD() {
		return calculateSLD;
	}
	public void setCalculateSLD(CalculateSLD calculateSLD) {
		this.calculateSLD = calculateSLD;
	}
	public CalculateSTD getCalculateSTD() {
		return calculateSTD;
	}
	public void setCalculateSTD(CalculateSTD calculateSTD) {
		this.calculateSTD = calculateSTD;
	}

	public TestEntity getMyTestEntity() {
		return myTestEntity;
	}

	public void setMyTestEntity(TestEntity myTestEntity) {
		this.myTestEntity = myTestEntity;
	}
	
	
	
}
