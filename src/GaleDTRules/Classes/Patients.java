/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleDTRules.Classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author NazonaX
 */
public class Patients implements BaseConverter{
    
    public static final String MALE = "male";
    public static final String FEMAL = "female";
    
    private int patientID;
    private String fullName;
    private int age;
    private String gender;
    private Date memberSince;
    
    private List<BMI_Dev> BMI_Devs = new ArrayList<BMI_Dev>();
    private List<Floors_Dev> Floors_Devs = new ArrayList<Floors_Dev>();
    private List<HR_Dev> HR_Devs = new ArrayList<HR_Dev>();
    private List<Sleep_Dev> Sleep_Devs = new ArrayList<Sleep_Dev>();
    private List<Steps_Dev> Steps_Devs = new ArrayList<Steps_Dev>();
    private List<Weight_Dev> Weight_Devs = new ArrayList<Weight_Dev>();
    private List<Result> Results = new ArrayList<>();
    
    

    /**
     * @return the patientID
     */
    public int getPatientID() {
        return patientID;
    }

    /**
     * @param patientID the patientID to set
     */
    public void setPatientID(Object patientID) {
        this.patientID = (int)patientID;
    }

    /**
     * @return the fullNameString
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullNameString the fullNameString to set
     */
    public void setFullName(Object fullNameString) {
        this.fullName = (String)fullNameString;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Object age) {
        this.age = (int)age;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(Object gender) {
        this.gender = (String)gender;
    }

    /**
     * @return the memberSince
     */
    public Date getMemberSince() {
        return memberSince;
    }

    /**
     * @param memberSince the memberSince to set
     */
    public void setMemberSince(Object memberSince) {
        this.memberSince = (Date)memberSince;
    }

    @Override
    public Object ConvertToDTRulesDataType() {
        edu.dhu.DTRules.entities.Patient pt = new edu.dhu.DTRules.entities.Patient();
        pt.setAge(this.age);
        pt.setGender(this.gender);
        pt.setPatientID(this.patientID);
        pt.setFullName(this.fullName);
        pt.setMemberSince(this.memberSince);
        for(BMI_Dev bmi : this.BMI_Devs){
            edu.dhu.DTRules.entities.BMI_Dev tmp = new edu.dhu.DTRules.entities.BMI_Dev();
            tmp.setBMI(bmi.getBMI());
            tmp.setBMIID(bmi.getBMIID());
            tmp.setDevID_FK(bmi.getDevID_FK());
            tmp.setPatientID_FK(bmi.getPatientID_FK());
            tmp.setDateTime(bmi.getDateTime());
            pt.getBMI_Devs().add(tmp);
        }
        for(Floors_Dev flr : this.Floors_Devs){
            edu.dhu.DTRules.entities.Floors_Dev tmp = new edu.dhu.DTRules.entities.Floors_Dev();
            tmp.setFloors(flr.getFloors());
            tmp.setFloorsID(flr.getFloorsID());
            tmp.setDevID_FK(flr.getDevID_FK());
            tmp.setPatientID_FK(flr.getPatientID_FK());
            tmp.setDateTime(flr.getDateTime());
            pt.getFloors_Devs().add(tmp);
        }
        for(HR_Dev hr : HR_Devs){
            edu.dhu.DTRules.entities.HR_Dev tmp = new edu.dhu.DTRules.entities.HR_Dev();
            tmp.setHR(hr.getHR());
            tmp.setHRID(hr.getHRID());
            tmp.setDevID_FK(hr.getDevID_FK());
            tmp.setPatientID_FK(hr.getPatientID_FK());
            tmp.setDateTime(hr.getDateTime());
            pt.getHR_Devs().add(tmp);
        }
        for(Sleep_Dev dlp : Sleep_Devs){
            edu.dhu.DTRules.entities.Sleep_Dev tmp = new edu.dhu.DTRules.entities.Sleep_Dev();
            tmp.setSleepMeasurement(dlp.getSleepMeasurement());
            tmp.setSleepID(dlp.getSleepID());
            tmp.setDevID_FK(dlp.getDevID_FK());
            tmp.setPatientID_FK(dlp.getPatientID_FK());
            tmp.setDateTime(dlp.getDateTime());
            pt.getSleep_Devs().add(tmp);
        }
        for(Steps_Dev stp : Steps_Devs){
            edu.dhu.DTRules.entities.Steps_Dev tmp = new edu.dhu.DTRules.entities.Steps_Dev();
            tmp.setSteps(stp.getSteps());
            tmp.setStepsID(stp.getStepsID());
            tmp.setDevID_FK(stp.getDevID_FK());
            tmp.setPatientID_FK(stp.getPatientID_FK());
            tmp.setDateTime(stp.getDateTime());
            pt.getSteps_Devs().add(tmp);
        }
        for(Weight_Dev wgt : Weight_Devs){
            edu.dhu.DTRules.entities.Weight_Dev tmp = new edu.dhu.DTRules.entities.Weight_Dev();
            tmp.setWeight(wgt.getWeight());
            tmp.setWeightID(wgt.getWeightID());
            tmp.setDevID_FK(wgt.getDevID_FK());
            tmp.setPatientID_FK(wgt.getPatientID_FK());
            tmp.setDateTime(wgt.getDateTime());
            pt.getWeight_Devs().add(tmp);
        }
        return pt;
    }

    /**
     * @return the BMI_Devs
     */
    public List<BMI_Dev> getBMI_Devs() {
        return BMI_Devs;
    }

    /**
     * @param BMI_Devs the BMI_Devs to set
     */
    public void setBMI_Devs(List<BMI_Dev> BMI_Devs) {
        this.BMI_Devs = BMI_Devs;
    }

    /**
     * @return the Floors_Devs
     */
    public List<Floors_Dev> getFloors_Devs() {
        return Floors_Devs;
    }

    /**
     * @param Floors_Devs the Floors_Devs to set
     */
    public void setFloors_Devs(List<Floors_Dev> Floors_Devs) {
        this.Floors_Devs = Floors_Devs;
    }

    /**
     * @return the HR_Devs
     */
    public List<HR_Dev> getHR_Devs() {
        return HR_Devs;
    }

    /**
     * @param HR_Devs the HR_Devs to set
     */
    public void setHR_Devs(List<HR_Dev> HR_Devs) {
        this.HR_Devs = HR_Devs;
    }

    /**
     * @return the Sleep_Devs
     */
    public List<Sleep_Dev> getSleep_Devs() {
        return Sleep_Devs;
    }

    /**
     * @param Sleep_Devs the Sleep_Devs to set
     */
    public void setSleep_Devs(List<Sleep_Dev> Sleep_Devs) {
        this.Sleep_Devs = Sleep_Devs;
    }

    /**
     * @return the Steps_Devs
     */
    public List<Steps_Dev> getSteps_Devs() {
        return Steps_Devs;
    }

    /**
     * @param Steps_Devs the Steps_Devs to set
     */
    public void setSteps_Devs(List<Steps_Dev> Steps_Devs) {
        this.Steps_Devs = Steps_Devs;
    }

    /**
     * @return the Weight_Devs
     */
    public List<Weight_Dev> getWeight_Devs() {
        return Weight_Devs;
    }

    /**
     * @param Weight_Devs the Weight_Devs to set
     */
    public void setWeight_Devs(List<Weight_Dev> Weight_Devs) {
        this.Weight_Devs = Weight_Devs;
    }

    /**
     * @return the Results
     */
    public List<Result> getResults() {
        return Results;
    }

    /**
     * @param Results the Results to set
     */
    public void setResults(List<Result> Results) {
        this.Results = Results;
    }
    
}
