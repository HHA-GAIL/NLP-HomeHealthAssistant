package edu.dhu.DTRules.entities;

import java.util.Date;

public class HR_Dev extends baseEntity {

	public Integer HRID;
	public Integer PatientID_FK;
	public Integer DevID_FK;
	public Integer HR;
	public Date DateTime;
	
	public Integer getHRID() {
		return HRID;
	}
	public void setHRID(Integer hRID) {
		HRID = hRID;
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
	public Integer getHR() {
		return HR;
	}
	public void setHR(Integer hR) {
		HR = hR;
	}
	public Date getDateTime() {
		return DateTime;
	}
	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}
	
	
	
}
