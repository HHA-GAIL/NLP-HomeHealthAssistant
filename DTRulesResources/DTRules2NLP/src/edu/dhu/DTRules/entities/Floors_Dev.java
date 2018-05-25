package edu.dhu.DTRules.entities;

import java.util.Date;

public class Floors_Dev extends baseEntity {

	public Integer FloorsID;
	public Integer PatientID_FK;
	public Integer DevID_FK;
	public Integer Floors;
	public Date DateTime;
	
	public Integer getFloorsID() {
		return FloorsID;
	}
	public void setFloorsID(Integer floorsID) {
		FloorsID = floorsID;
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
	public Integer getFloors() {
		return Floors;
	}
	public void setFloors(Integer floors) {
		Floors = floors;
	}
	public Date getDateTime() {
		return DateTime;
	}
	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}
	
	
	
}
