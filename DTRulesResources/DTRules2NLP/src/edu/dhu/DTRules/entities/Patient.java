package edu.dhu.DTRules.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Patient extends baseEntity {

	public static final String MALE = "male";
	public static final String FEMALE = "female";
	
	public Integer PatientID;
	public String FullName;
	public Integer Age;
	public String Gender;
	public Date MemberSince;
	
	public List<BMI_Dev> BMI_Devs = new ArrayList<BMI_Dev>();
	public List<Floors_Dev> Floors_Devs = new ArrayList<Floors_Dev>();
	public List<HR_Dev> HR_Devs = new ArrayList<HR_Dev>();
	public List<Sleep_Dev> Sleep_Devs = new ArrayList<Sleep_Dev>();
	public List<Steps_Dev> Steps_Devs = new ArrayList<Steps_Dev>();
	public List<Weight_Dev> Weight_Devs = new ArrayList<Weight_Dev>();
	public List<Result> Results = new ArrayList<Result>();
	

	public List<Result> getResults() {
		return Results;
	}
	public void setResults(List<Result> results) {
		Results = results;
	}
	public Integer getPatientID() {
		return PatientID;
	}
	public void setPatientID(Integer patientID) {
		PatientID = patientID;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public Integer getAge() {
		return Age;
	}
	public void setAge(Integer age) {
		Age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Date getMemberSince() {
		return MemberSince;
	}
	public void setMemberSince(Date memberSince) {
		MemberSince = memberSince;
	}
	public List<BMI_Dev> getBMI_Devs() {
		return BMI_Devs;
	}
	public void setBMI_Devs(List<BMI_Dev> bMI_Devs) {
		BMI_Devs = bMI_Devs;
	}
	public List<Floors_Dev> getFloors_Devs() {
		return Floors_Devs;
	}
	public void setFloors_Devs(List<Floors_Dev> floors_Devs) {
		Floors_Devs = floors_Devs;
	}
	public List<HR_Dev> getHR_Devs() {
		return HR_Devs;
	}
	public void setHR_Devs(List<HR_Dev> hR_Devs) {
		HR_Devs = hR_Devs;
	}
	public List<Sleep_Dev> getSleep_Devs() {
		return Sleep_Devs;
	}
	public void setSleep_Devs(List<Sleep_Dev> sleep_Devs) {
		Sleep_Devs = sleep_Devs;
	}
	public List<Steps_Dev> getSteps_Devs() {
		return Steps_Devs;
	}
	public void setSteps_Devs(List<Steps_Dev> steps_Devs) {
		Steps_Devs = steps_Devs;
	}
	public List<Weight_Dev> getWeight_Devs() {
		return Weight_Devs;
	}
	public void setWeight_Devs(List<Weight_Dev> weight_Devs) {
		Weight_Devs = weight_Devs;
	}
	
}
