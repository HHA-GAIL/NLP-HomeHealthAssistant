package edu.dhu.DTRules.entities;

import java.util.Date;

import javax.xml.crypto.Data;

public class Sleep_Dev extends baseEntity {

	public Integer SleepID;
	public Integer PatientID_FK;
	public Integer DevID_FK;
	public Double SleepMeasurement;
	public String SleepResults;
	public Date DateTime;
	
	public Integer getSleepID() {
		return SleepID;
	}
	public void setSleepID(Integer sleepID) {
		SleepID = sleepID;
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
	public Double getSleepMeasurement() {
		return SleepMeasurement;
	}
	public void setSleepMeasurement(Double sleepMeasurement) {
		SleepMeasurement = sleepMeasurement;
	}
	public Date getDateTime() {
		return DateTime;
	}
	public void setDateTime(Date date) {
		DateTime = date;
	}
	public String getSleepResults() {
		return SleepResults;
	}
	public void setSleepResults(String sleepResult) {
		SleepResults = sleepResult;
	}
	
}
