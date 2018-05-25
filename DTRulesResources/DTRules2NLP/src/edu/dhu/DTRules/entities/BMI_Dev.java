package edu.dhu.DTRules.entities;

import java.util.Date;

public class BMI_Dev extends baseEntity {

	public Integer BMIID;
	public Integer PatientID_FK;
	public Integer DevID_FK;
	public Double BMI;
	public Date DateTime;
	
	
	public Integer getBMIID() {
		return BMIID;
	}
	public void setBMIID(Integer bMIID) {
		BMIID = bMIID;
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
	public Double getBMI() {
		return BMI;
	}
	public void setBMI(Double bMI) {
		BMI = bMI;
	}
	public Date getDateTime() {
		return DateTime;
	}
	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}
	
	
	
}
