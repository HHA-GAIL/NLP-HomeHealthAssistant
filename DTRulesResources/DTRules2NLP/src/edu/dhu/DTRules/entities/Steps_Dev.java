package edu.dhu.DTRules.entities;

import java.util.Date;


public class Steps_Dev extends baseEntity {

	public Integer StepsID;
	public Integer PatientID_FK;
	public Integer DevID_FK;
	public Double Steps;
	public Date DateTime;
	
	public Integer getStepsID() {
		return StepsID;
	}
	public void setStepsID(Integer stepsID) {
		StepsID = stepsID;
	}
	public Integer getPatientID_FK() {
		return PatientID_FK;
	}
	public void setPatientID_FK(Integer patientID_FK) {
		PatientID_FK = patientID_FK;
	}
	public Integer getDevID_FK() {
		return DevID_FK;
	}
	public void setDevID_FK(Integer devID_FK) {
		DevID_FK = devID_FK;
	}
	public Double getSteps() {
		return Steps;
	}
	public void setSteps(Double steps) {
		Steps = steps;
	}
	public Date getDateTime() {
		return DateTime;
	}
	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}
	
	
	
}
