package edu.dhu.DTRules.entities;

import java.util.Date;


public class Weight_Dev extends baseEntity {

	public Integer WeightID;
	public Integer PatientID_FK;
	public Integer DevID_FK;
	public Double Weight;
	public Date DateTime;
	
	public Integer getWeightID() {
		return WeightID;
	}
	public void setWeightID(Integer weightID) {
		WeightID = weightID;
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
	public Double getWeight() {
		return Weight;
	}
	public void setWeight(Double weight) {
		Weight = weight;
	}
	public Date getDateTime() {
		return DateTime;
	}
	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}
	
	
	
}
